package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class duv
  extends cvc
{
  public SKBuiltinBuffer_t HHm;
  public int HHn;
  public int HHo;
  public String HHp;
  public String Hfq;
  public String Hfr;
  public int Hfs;
  public String Hft;
  public String ProductID;
  public int wDv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91722);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HHm == null)
      {
        paramVarArgs = new b("Not all required fields were included: Receipt");
        AppMethodBeat.o(91722);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HHm != null)
      {
        paramVarArgs.lC(2, this.HHm.computeSize());
        this.HHm.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(3, this.ProductID);
      }
      paramVarArgs.aS(4, this.HHn);
      paramVarArgs.aS(5, this.wDv);
      if (this.Hfq != null) {
        paramVarArgs.d(6, this.Hfq);
      }
      if (this.Hfr != null) {
        paramVarArgs.d(7, this.Hfr);
      }
      if (this.Hft != null) {
        paramVarArgs.d(8, this.Hft);
      }
      paramVarArgs.aS(9, this.HHo);
      if (this.HHp != null) {
        paramVarArgs.d(10, this.HHp);
      }
      paramVarArgs.aS(11, this.Hfs);
      AppMethodBeat.o(91722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label998;
      }
    }
    label998:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HHm != null) {
        paramInt = i + f.a.a.a.lB(2, this.HHm.computeSize());
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ProductID);
      }
      i = i + f.a.a.b.b.a.bz(4, this.HHn) + f.a.a.b.b.a.bz(5, this.wDv);
      paramInt = i;
      if (this.Hfq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hfq);
      }
      i = paramInt;
      if (this.Hfr != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Hfr);
      }
      paramInt = i;
      if (this.Hft != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hft);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.HHo);
      paramInt = i;
      if (this.HHp != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HHp);
      }
      i = f.a.a.b.b.a.bz(11, this.Hfs);
      AppMethodBeat.o(91722);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HHm == null)
        {
          paramVarArgs = new b("Not all required fields were included: Receipt");
          AppMethodBeat.o(91722);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        duv localduv = (duv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91722);
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
            localduv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduv.HHm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 3: 
          localduv.ProductID = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 4: 
          localduv.HHn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91722);
          return 0;
        case 5: 
          localduv.wDv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91722);
          return 0;
        case 6: 
          localduv.Hfq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 7: 
          localduv.Hfr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 8: 
          localduv.Hft = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 9: 
          localduv.HHo = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91722);
          return 0;
        case 10: 
          localduv.HHp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91722);
          return 0;
        }
        localduv.Hfs = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91722);
        return 0;
      }
      AppMethodBeat.o(91722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duv
 * JD-Core Version:    0.7.0.1
 */