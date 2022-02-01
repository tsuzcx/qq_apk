package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ddu
  extends cvw
{
  public int FOQ;
  public int GVy;
  public int GVz;
  public float Gha;
  public int GqB;
  public int HLm;
  public float HLn;
  public float HLo;
  public int ijY;
  public SKBuiltinBuffer_t xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32444);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32444);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xsE != null)
      {
        paramVarArgs.lJ(2, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HLm);
      paramVarArgs.aS(4, this.ijY);
      paramVarArgs.y(5, this.HLn);
      paramVarArgs.aS(6, this.GqB);
      paramVarArgs.aS(7, this.FOQ);
      paramVarArgs.y(8, this.HLo);
      paramVarArgs.y(9, this.Gha);
      paramVarArgs.aS(10, this.GVy);
      paramVarArgs.aS(11, this.GVz);
      AppMethodBeat.o(32444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label952;
      }
    }
    label952:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xsE != null) {
        i = paramInt + f.a.a.a.lI(2, this.xsE.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HLm);
      int j = f.a.a.b.b.a.bz(4, this.ijY);
      int k = f.a.a.b.b.a.amE(5);
      int m = f.a.a.b.b.a.bz(6, this.GqB);
      int n = f.a.a.b.b.a.bz(7, this.FOQ);
      int i1 = f.a.a.b.b.a.amE(8);
      int i2 = f.a.a.b.b.a.amE(9);
      int i3 = f.a.a.b.b.a.bz(10, this.GVy);
      int i4 = f.a.a.b.b.a.bz(11, this.GVz);
      AppMethodBeat.o(32444);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.xsE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32444);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddu localddu = (ddu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32444);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32444);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddu.xsE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32444);
          return 0;
        case 3: 
          localddu.HLm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32444);
          return 0;
        case 4: 
          localddu.ijY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32444);
          return 0;
        case 5: 
          localddu.HLn = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(32444);
          return 0;
        case 6: 
          localddu.GqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32444);
          return 0;
        case 7: 
          localddu.FOQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32444);
          return 0;
        case 8: 
          localddu.HLo = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(32444);
          return 0;
        case 9: 
          localddu.Gha = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(32444);
          return 0;
        case 10: 
          localddu.GVy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32444);
          return 0;
        }
        localddu.GVz = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32444);
        return 0;
      }
      AppMethodBeat.o(32444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddu
 * JD-Core Version:    0.7.0.1
 */