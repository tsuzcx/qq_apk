package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hq
  extends cvw
{
  public int FJf;
  public SKBuiltinBuffer_t FSF;
  public String FSe;
  public String FSh;
  public SKBuiltinBuffer_t FSj;
  public String jfY;
  public String nIN;
  public String qkM;
  public String qkN;
  public String uQx;
  public int uuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133150);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FSF == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133150);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.uuz);
      if (this.FSF != null)
      {
        paramVarArgs.lJ(3, this.FSF.computeSize());
        this.FSF.writeFields(paramVarArgs);
      }
      if (this.uQx != null) {
        paramVarArgs.d(4, this.uQx);
      }
      if (this.FSe != null) {
        paramVarArgs.d(5, this.FSe);
      }
      if (this.jfY != null) {
        paramVarArgs.d(6, this.jfY);
      }
      if (this.nIN != null) {
        paramVarArgs.d(7, this.nIN);
      }
      if (this.FSh != null) {
        paramVarArgs.d(8, this.FSh);
      }
      if (this.qkN != null) {
        paramVarArgs.d(9, this.qkN);
      }
      if (this.qkM != null) {
        paramVarArgs.d(10, this.qkM);
      }
      paramVarArgs.aS(11, this.FJf);
      if (this.FSj != null)
      {
        paramVarArgs.lJ(12, this.FSj.computeSize());
        this.FSj.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.uuz);
      paramInt = i;
      if (this.FSF != null) {
        paramInt = i + f.a.a.a.lI(3, this.FSF.computeSize());
      }
      i = paramInt;
      if (this.uQx != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uQx);
      }
      paramInt = i;
      if (this.FSe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FSe);
      }
      i = paramInt;
      if (this.jfY != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.jfY);
      }
      paramInt = i;
      if (this.nIN != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nIN);
      }
      i = paramInt;
      if (this.FSh != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FSh);
      }
      paramInt = i;
      if (this.qkN != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.qkN);
      }
      i = paramInt;
      if (this.qkM != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.qkM);
      }
      i += f.a.a.b.b.a.bz(11, this.FJf);
      paramInt = i;
      if (this.FSj != null) {
        paramInt = i + f.a.a.a.lI(12, this.FSj.computeSize());
      }
      AppMethodBeat.o(133150);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FSF == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 2: 
          localhq.uuz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133150);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhq.FSF = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 4: 
          localhq.uQx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 5: 
          localhq.FSe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 6: 
          localhq.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 7: 
          localhq.nIN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 8: 
          localhq.FSh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 9: 
          localhq.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 10: 
          localhq.qkM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 11: 
          localhq.FJf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133150);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhq.FSj = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hq
 * JD-Core Version:    0.7.0.1
 */