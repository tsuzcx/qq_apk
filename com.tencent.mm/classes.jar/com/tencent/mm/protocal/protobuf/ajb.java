package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ajb
  extends cvp
{
  public LinkedList<bst> FUp;
  public cmn Ggf;
  public String Ggg;
  public String Ggh;
  public String Ggi;
  public String Ggj;
  public float Ggk;
  public String Ggl;
  public int rgn;
  public String rgo;
  
  public ajb()
  {
    AppMethodBeat.i(104361);
    this.FUp = new LinkedList();
    AppMethodBeat.o(104361);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104362);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104362);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FUp);
      if (this.Ggf != null)
      {
        paramVarArgs.lC(3, this.Ggf.computeSize());
        this.Ggf.writeFields(paramVarArgs);
      }
      if (this.Ggg != null) {
        paramVarArgs.d(4, this.Ggg);
      }
      if (this.Ggh != null) {
        paramVarArgs.d(5, this.Ggh);
      }
      if (this.Ggi != null) {
        paramVarArgs.d(6, this.Ggi);
      }
      if (this.Ggj != null) {
        paramVarArgs.d(7, this.Ggj);
      }
      paramVarArgs.z(8, this.Ggk);
      paramVarArgs.aS(9, this.rgn);
      if (this.rgo != null) {
        paramVarArgs.d(10, this.rgo);
      }
      if (this.Ggl != null) {
        paramVarArgs.d(11, this.Ggl);
      }
      AppMethodBeat.o(104362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1109;
      }
    }
    label1109:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FUp);
      paramInt = i;
      if (this.Ggf != null) {
        paramInt = i + f.a.a.a.lB(3, this.Ggf.computeSize());
      }
      i = paramInt;
      if (this.Ggg != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Ggg);
      }
      paramInt = i;
      if (this.Ggh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ggh);
      }
      i = paramInt;
      if (this.Ggi != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Ggi);
      }
      paramInt = i;
      if (this.Ggj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ggj);
      }
      i = paramInt + f.a.a.b.b.a.alU(8) + f.a.a.b.b.a.bz(9, this.rgn);
      paramInt = i;
      if (this.rgo != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.rgo);
      }
      i = paramInt;
      if (this.Ggl != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Ggl);
      }
      AppMethodBeat.o(104362);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104362);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajb localajb = (ajb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104362);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bst();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bst)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajb.FUp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajb.Ggf = ((cmn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 4: 
          localajb.Ggg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 5: 
          localajb.Ggh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 6: 
          localajb.Ggi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 7: 
          localajb.Ggj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 8: 
          localajb.Ggk = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(104362);
          return 0;
        case 9: 
          localajb.rgn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104362);
          return 0;
        case 10: 
          localajb.rgo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104362);
          return 0;
        }
        localajb.Ggl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(104362);
        return 0;
      }
      AppMethodBeat.o(104362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajb
 * JD-Core Version:    0.7.0.1
 */