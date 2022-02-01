package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class brs
  extends dyl
{
  public eml REA;
  public String REw;
  public String REx;
  public int REy;
  public String Tcj;
  public String fUL;
  public String fUM;
  public int fUN;
  public String from_username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114010);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fUL == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(114010);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fUL != null) {
        paramVarArgs.f(2, this.fUL);
      }
      paramVarArgs.aY(3, this.fUN);
      if (this.from_username != null) {
        paramVarArgs.f(4, this.from_username);
      }
      if (this.fUM != null) {
        paramVarArgs.f(5, this.fUM);
      }
      if (this.REw != null) {
        paramVarArgs.f(6, this.REw);
      }
      if (this.REx != null) {
        paramVarArgs.f(7, this.REx);
      }
      paramVarArgs.aY(8, this.REy);
      if (this.Tcj != null) {
        paramVarArgs.f(9, this.Tcj);
      }
      if (this.REA != null)
      {
        paramVarArgs.oE(10, this.REA.computeSize());
        this.REA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114010);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fUL != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.fUL);
      }
      i += g.a.a.b.b.a.bM(3, this.fUN);
      paramInt = i;
      if (this.from_username != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.from_username);
      }
      i = paramInt;
      if (this.fUM != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fUM);
      }
      paramInt = i;
      if (this.REw != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.REw);
      }
      i = paramInt;
      if (this.REx != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.REx);
      }
      i += g.a.a.b.b.a.bM(8, this.REy);
      paramInt = i;
      if (this.Tcj != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Tcj);
      }
      i = paramInt;
      if (this.REA != null) {
        i = paramInt + g.a.a.a.oD(10, this.REA.computeSize());
      }
      AppMethodBeat.o(114010);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fUL == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(114010);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114010);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        brs localbrs = (brs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114010);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbrs.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114010);
          return 0;
        case 2: 
          localbrs.fUL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 3: 
          localbrs.fUN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114010);
          return 0;
        case 4: 
          localbrs.from_username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 5: 
          localbrs.fUM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 6: 
          localbrs.REw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 7: 
          localbrs.REx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 8: 
          localbrs.REy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114010);
          return 0;
        case 9: 
          localbrs.Tcj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114010);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eml();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eml)localObject2).parseFrom((byte[])localObject1);
          }
          localbrs.REA = ((eml)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114010);
        return 0;
      }
      AppMethodBeat.o(114010);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brs
 * JD-Core Version:    0.7.0.1
 */