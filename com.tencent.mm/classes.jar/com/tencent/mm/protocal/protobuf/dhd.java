package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhd
  extends cvc
{
  public int ExtFlag;
  public SKBuiltinBuffer_t FAN;
  public int FYc;
  public String Fvh;
  public int GTf;
  public int GTg;
  public dqc Hex;
  public int HvE;
  public int HvF;
  public int HvG;
  public String MD5;
  public String hCW;
  public String iht;
  public int nEf;
  public int xcK;
  public int xcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125830);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(125830);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nEf);
      paramVarArgs.aS(3, this.xcL);
      paramVarArgs.aS(17, this.HvE);
      paramVarArgs.aS(4, this.xcK);
      if (this.FAN != null)
      {
        paramVarArgs.lC(5, this.FAN.computeSize());
        this.FAN.writeFields(paramVarArgs);
      }
      if (this.hCW != null) {
        paramVarArgs.d(6, this.hCW);
      }
      paramVarArgs.aS(7, this.GTf);
      paramVarArgs.aS(8, this.GTg);
      if (this.Fvh != null) {
        paramVarArgs.d(9, this.Fvh);
      }
      paramVarArgs.aS(10, this.HvF);
      paramVarArgs.aS(11, this.FYc);
      if (this.Hex != null)
      {
        paramVarArgs.lC(12, this.Hex.computeSize());
        this.Hex.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(13, this.iht);
      }
      paramVarArgs.aS(14, this.ExtFlag);
      if (this.MD5 != null) {
        paramVarArgs.d(15, this.MD5);
      }
      paramVarArgs.aS(16, this.HvG);
      AppMethodBeat.o(125830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1362;
      }
    }
    label1362:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEf) + f.a.a.b.b.a.bz(3, this.xcL) + f.a.a.b.b.a.bz(17, this.HvE) + f.a.a.b.b.a.bz(4, this.xcK);
      paramInt = i;
      if (this.FAN != null) {
        paramInt = i + f.a.a.a.lB(5, this.FAN.computeSize());
      }
      i = paramInt;
      if (this.hCW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hCW);
      }
      i = i + f.a.a.b.b.a.bz(7, this.GTf) + f.a.a.b.b.a.bz(8, this.GTg);
      paramInt = i;
      if (this.Fvh != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Fvh);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.HvF) + f.a.a.b.b.a.bz(11, this.FYc);
      paramInt = i;
      if (this.Hex != null) {
        paramInt = i + f.a.a.a.lB(12, this.Hex.computeSize());
      }
      i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.iht);
      }
      i += f.a.a.b.b.a.bz(14, this.ExtFlag);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.MD5);
      }
      i = f.a.a.b.b.a.bz(16, this.HvG);
      AppMethodBeat.o(125830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FAN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(125830);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhd localdhd = (dhd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125830);
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
            localdhd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 2: 
          localdhd.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 3: 
          localdhd.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 17: 
          localdhd.HvE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 4: 
          localdhd.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhd.FAN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 6: 
          localdhd.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 7: 
          localdhd.GTf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 8: 
          localdhd.GTg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 9: 
          localdhd.Fvh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 10: 
          localdhd.HvF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 11: 
          localdhd.FYc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhd.Hex = ((dqc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 13: 
          localdhd.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 14: 
          localdhd.ExtFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125830);
          return 0;
        case 15: 
          localdhd.MD5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125830);
          return 0;
        }
        localdhd.HvG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125830);
        return 0;
      }
      AppMethodBeat.o(125830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhd
 * JD-Core Version:    0.7.0.1
 */