package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uh
  extends com.tencent.mm.cd.a
{
  public String RFf;
  public String SeT;
  public String See;
  public int Sep;
  public String Seq;
  public up Ser;
  public String Ses;
  public String fUL;
  public String jEi;
  public int qJt;
  public String title;
  public String ufC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249095);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fUL != null) {
        paramVarArgs.f(1, this.fUL);
      }
      if (this.RFf != null) {
        paramVarArgs.f(2, this.RFf);
      }
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.jEi != null) {
        paramVarArgs.f(4, this.jEi);
      }
      if (this.SeT != null) {
        paramVarArgs.f(5, this.SeT);
      }
      if (this.See != null) {
        paramVarArgs.f(6, this.See);
      }
      paramVarArgs.aY(7, this.qJt);
      if (this.ufC != null) {
        paramVarArgs.f(8, this.ufC);
      }
      paramVarArgs.aY(9, this.Sep);
      if (this.Seq != null) {
        paramVarArgs.f(10, this.Seq);
      }
      if (this.Ser != null)
      {
        paramVarArgs.oE(11, this.Ser.computeSize());
        this.Ser.writeFields(paramVarArgs);
      }
      if (this.Ses != null) {
        paramVarArgs.f(12, this.Ses);
      }
      AppMethodBeat.o(249095);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fUL == null) {
        break label932;
      }
    }
    label932:
    for (int i = g.a.a.b.b.a.g(1, this.fUL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RFf != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RFf);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.title);
      }
      paramInt = i;
      if (this.jEi != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jEi);
      }
      i = paramInt;
      if (this.SeT != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SeT);
      }
      paramInt = i;
      if (this.See != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.See);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.qJt);
      paramInt = i;
      if (this.ufC != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ufC);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.Sep);
      paramInt = i;
      if (this.Seq != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Seq);
      }
      i = paramInt;
      if (this.Ser != null) {
        i = paramInt + g.a.a.a.oD(11, this.Ser.computeSize());
      }
      paramInt = i;
      if (this.Ses != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.Ses);
      }
      AppMethodBeat.o(249095);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(249095);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        uh localuh = (uh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(249095);
          return -1;
        case 1: 
          localuh.fUL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249095);
          return 0;
        case 2: 
          localuh.RFf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249095);
          return 0;
        case 3: 
          localuh.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249095);
          return 0;
        case 4: 
          localuh.jEi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249095);
          return 0;
        case 5: 
          localuh.SeT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249095);
          return 0;
        case 6: 
          localuh.See = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249095);
          return 0;
        case 7: 
          localuh.qJt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(249095);
          return 0;
        case 8: 
          localuh.ufC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249095);
          return 0;
        case 9: 
          localuh.Sep = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(249095);
          return 0;
        case 10: 
          localuh.Seq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249095);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            up localup = new up();
            if ((localObject != null) && (localObject.length > 0)) {
              localup.parseFrom((byte[])localObject);
            }
            localuh.Ser = localup;
            paramInt += 1;
          }
          AppMethodBeat.o(249095);
          return 0;
        }
        localuh.Ses = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(249095);
        return 0;
      }
      AppMethodBeat.o(249095);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uh
 * JD-Core Version:    0.7.0.1
 */