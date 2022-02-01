package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuf
  extends cvc
{
  public LinkedList<String> EmotionList;
  public String FGP;
  public ctz Hmd;
  public cuv Hme;
  public int nEf;
  
  public cuf()
  {
    AppMethodBeat.i(115964);
    this.EmotionList = new LinkedList();
    AppMethodBeat.o(115964);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nEf);
      if (this.Hmd != null)
      {
        paramVarArgs.lC(3, this.Hmd.computeSize());
        this.Hmd.writeFields(paramVarArgs);
      }
      if (this.Hme != null)
      {
        paramVarArgs.lC(4, this.Hme.computeSize());
        this.Hme.writeFields(paramVarArgs);
      }
      if (this.FGP != null) {
        paramVarArgs.d(5, this.FGP);
      }
      paramVarArgs.e(6, 1, this.EmotionList);
      AppMethodBeat.o(115965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEf);
      paramInt = i;
      if (this.Hmd != null) {
        paramInt = i + f.a.a.a.lB(3, this.Hmd.computeSize());
      }
      i = paramInt;
      if (this.Hme != null) {
        i = paramInt + f.a.a.a.lB(4, this.Hme.computeSize());
      }
      paramInt = i;
      if (this.FGP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FGP);
      }
      i = f.a.a.a.c(6, 1, this.EmotionList);
      AppMethodBeat.o(115965);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmotionList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(115965);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cuf localcuf = (cuf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115965);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 2: 
          localcuf.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115965);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuf.Hmd = ((ctz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cuv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cuv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuf.Hme = ((cuv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 5: 
          localcuf.FGP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115965);
          return 0;
        }
        localcuf.EmotionList.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(115965);
        return 0;
      }
      AppMethodBeat.o(115965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuf
 * JD-Core Version:    0.7.0.1
 */