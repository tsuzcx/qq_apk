package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hf
  extends ckq
{
  public String CBO;
  public String CBS;
  public SKBuiltinBuffer_t CBU;
  public int CCp;
  public SKBuiltinBuffer_t CCq;
  public int Ctl;
  public String ijP;
  public String mAU;
  public String oXr;
  public String oXs;
  public String sul;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133150);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CCq == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133150);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CCp);
      if (this.CCq != null)
      {
        paramVarArgs.kX(3, this.CCq.computeSize());
        this.CCq.writeFields(paramVarArgs);
      }
      if (this.sul != null) {
        paramVarArgs.d(4, this.sul);
      }
      if (this.CBO != null) {
        paramVarArgs.d(5, this.CBO);
      }
      if (this.ijP != null) {
        paramVarArgs.d(6, this.ijP);
      }
      if (this.mAU != null) {
        paramVarArgs.d(7, this.mAU);
      }
      if (this.CBS != null) {
        paramVarArgs.d(8, this.CBS);
      }
      if (this.oXs != null) {
        paramVarArgs.d(9, this.oXs);
      }
      if (this.oXr != null) {
        paramVarArgs.d(10, this.oXr);
      }
      paramVarArgs.aR(11, this.Ctl);
      if (this.CBU != null)
      {
        paramVarArgs.kX(12, this.CBU.computeSize());
        this.CBU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133150);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1190;
      }
    }
    label1190:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CCp);
      paramInt = i;
      if (this.CCq != null) {
        paramInt = i + f.a.a.a.kW(3, this.CCq.computeSize());
      }
      i = paramInt;
      if (this.sul != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sul);
      }
      paramInt = i;
      if (this.CBO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CBO);
      }
      i = paramInt;
      if (this.ijP != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ijP);
      }
      paramInt = i;
      if (this.mAU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.mAU);
      }
      i = paramInt;
      if (this.CBS != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CBS);
      }
      paramInt = i;
      if (this.oXs != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.oXs);
      }
      i = paramInt;
      if (this.oXr != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.oXr);
      }
      i += f.a.a.b.b.a.bA(11, this.Ctl);
      paramInt = i;
      if (this.CBU != null) {
        paramInt = i + f.a.a.a.kW(12, this.CBU.computeSize());
      }
      AppMethodBeat.o(133150);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CCq == null)
        {
          paramVarArgs = new b("Not all required fields were included: AxTicket");
          AppMethodBeat.o(133150);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133150);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hf localhf = (hf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133150);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 2: 
          localhf.CCp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133150);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhf.CCq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 4: 
          localhf.sul = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 5: 
          localhf.CBO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 6: 
          localhf.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 7: 
          localhf.mAU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 8: 
          localhf.CBS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 9: 
          localhf.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 10: 
          localhf.oXr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 11: 
          localhf.Ctl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133150);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhf.CBU = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133150);
        return 0;
      }
      AppMethodBeat.o(133150);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hf
 * JD-Core Version:    0.7.0.1
 */