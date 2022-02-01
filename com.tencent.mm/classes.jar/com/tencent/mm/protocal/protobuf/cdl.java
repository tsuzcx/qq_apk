package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cdl
  extends dyl
{
  public String RMJ;
  public eae RQU;
  public int Swu;
  public String Tli;
  public String Tlj;
  public String Tlk;
  public String Tll;
  public String Tlm;
  public String rWI;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155417);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RQU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155417);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RQU != null)
      {
        paramVarArgs.oE(2, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      if (this.Tli != null) {
        paramVarArgs.f(3, this.Tli);
      }
      if (this.Tlj != null) {
        paramVarArgs.f(4, this.Tlj);
      }
      if (this.rWI != null) {
        paramVarArgs.f(5, this.rWI);
      }
      if (this.Tlk != null) {
        paramVarArgs.f(6, this.Tlk);
      }
      if (this.Tll != null) {
        paramVarArgs.f(7, this.Tll);
      }
      if (this.Tlm != null) {
        paramVarArgs.f(8, this.Tlm);
      }
      paramVarArgs.aY(9, this.Swu);
      if (this.vhq != null) {
        paramVarArgs.f(10, this.vhq);
      }
      if (this.RMJ != null) {
        paramVarArgs.f(11, this.RMJ);
      }
      AppMethodBeat.o(155417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1006;
      }
    }
    label1006:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RQU != null) {
        paramInt = i + g.a.a.a.oD(2, this.RQU.computeSize());
      }
      i = paramInt;
      if (this.Tli != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tli);
      }
      paramInt = i;
      if (this.Tlj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tlj);
      }
      i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.rWI);
      }
      paramInt = i;
      if (this.Tlk != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tlk);
      }
      i = paramInt;
      if (this.Tll != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Tll);
      }
      paramInt = i;
      if (this.Tlm != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Tlm);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.Swu);
      paramInt = i;
      if (this.vhq != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.vhq);
      }
      i = paramInt;
      if (this.RMJ != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.RMJ);
      }
      AppMethodBeat.o(155417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RQU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(155417);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cdl localcdl = (cdl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155417);
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
            localcdl.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localcdl.RQU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 3: 
          localcdl.Tli = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 4: 
          localcdl.Tlj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 5: 
          localcdl.rWI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 6: 
          localcdl.Tlk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 7: 
          localcdl.Tll = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 8: 
          localcdl.Tlm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 9: 
          localcdl.Swu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155417);
          return 0;
        case 10: 
          localcdl.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155417);
          return 0;
        }
        localcdl.RMJ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(155417);
        return 0;
      }
      AppMethodBeat.o(155417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdl
 * JD-Core Version:    0.7.0.1
 */