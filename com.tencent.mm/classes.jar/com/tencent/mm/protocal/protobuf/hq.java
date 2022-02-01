package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hq
  extends cvc
{
  public int FAh;
  public SKBuiltinBuffer_t FAi;
  public int FqH;
  public String FzG;
  public String FzJ;
  public SKBuiltinBuffer_t FzL;
  public String jdf;
  public String nDs;
  public String qeh;
  public String qei;
  public String uEK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133150);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133150);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FAh);
      if (this.FAi != null)
      {
        paramVarArgs.lC(3, this.FAi.computeSize());
        this.FAi.writeFields(paramVarArgs);
      }
      if (this.uEK != null) {
        paramVarArgs.d(4, this.uEK);
      }
      if (this.FzG != null) {
        paramVarArgs.d(5, this.FzG);
      }
      if (this.jdf != null) {
        paramVarArgs.d(6, this.jdf);
      }
      if (this.nDs != null) {
        paramVarArgs.d(7, this.nDs);
      }
      if (this.FzJ != null) {
        paramVarArgs.d(8, this.FzJ);
      }
      if (this.qei != null) {
        paramVarArgs.d(9, this.qei);
      }
      if (this.qeh != null) {
        paramVarArgs.d(10, this.qeh);
      }
      paramVarArgs.aS(11, this.FqH);
      if (this.FzL != null)
      {
        paramVarArgs.lC(12, this.FzL.computeSize());
        this.FzL.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FAh);
      paramInt = i;
      if (this.FAi != null) {
        paramInt = i + f.a.a.a.lB(3, this.FAi.computeSize());
      }
      i = paramInt;
      if (this.uEK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uEK);
      }
      paramInt = i;
      if (this.FzG != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FzG);
      }
      i = paramInt;
      if (this.jdf != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.jdf);
      }
      paramInt = i;
      if (this.nDs != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nDs);
      }
      i = paramInt;
      if (this.FzJ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FzJ);
      }
      paramInt = i;
      if (this.qei != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.qei);
      }
      i = paramInt;
      if (this.qeh != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.qeh);
      }
      i += f.a.a.b.b.a.bz(11, this.FqH);
      paramInt = i;
      if (this.FzL != null) {
        paramInt = i + f.a.a.a.lB(12, this.FzL.computeSize());
      }
      AppMethodBeat.o(133150);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FAi == null)
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
        hq localhq = (hq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133150);
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
            localhq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 2: 
          localhq.FAh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133150);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhq.FAi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 4: 
          localhq.uEK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 5: 
          localhq.FzG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 6: 
          localhq.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 7: 
          localhq.nDs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 8: 
          localhq.FzJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 9: 
          localhq.qei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 10: 
          localhq.qeh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 11: 
          localhq.FqH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133150);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhq.FzL = ((SKBuiltinBuffer_t)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hq
 * JD-Core Version:    0.7.0.1
 */