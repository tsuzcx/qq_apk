package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dlq
  extends cvw
{
  public b Buffer;
  public String FZa;
  public int FZk;
  public int GbY;
  public int HSW;
  public int HTb;
  public String HTc;
  public clv HTd;
  public int Scene;
  public String ikm;
  public LinkedList<dlp> usl;
  
  public dlq()
  {
    AppMethodBeat.i(152704);
    this.usl = new LinkedList();
    AppMethodBeat.o(152704);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152705);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FZa != null) {
        paramVarArgs.d(2, this.FZa);
      }
      paramVarArgs.aS(3, this.GbY);
      paramVarArgs.e(4, 8, this.usl);
      paramVarArgs.aS(5, this.HTb);
      if (this.ikm != null) {
        paramVarArgs.d(6, this.ikm);
      }
      paramVarArgs.aS(7, this.FZk);
      paramVarArgs.aS(8, this.HSW);
      if (this.HTc != null) {
        paramVarArgs.d(9, this.HTc);
      }
      if (this.Buffer != null) {
        paramVarArgs.c(10, this.Buffer);
      }
      if (this.HTd != null)
      {
        paramVarArgs.lJ(11, this.HTd.computeSize());
        this.HTd.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.Scene);
      AppMethodBeat.o(152705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1074;
      }
    }
    label1074:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FZa != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FZa);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GbY) + f.a.a.a.c(4, 8, this.usl) + f.a.a.b.b.a.bz(5, this.HTb);
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ikm);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.FZk) + f.a.a.b.b.a.bz(8, this.HSW);
      paramInt = i;
      if (this.HTc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HTc);
      }
      i = paramInt;
      if (this.Buffer != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.Buffer);
      }
      paramInt = i;
      if (this.HTd != null) {
        paramInt = i + f.a.a.a.lI(11, this.HTd.computeSize());
      }
      i = f.a.a.b.b.a.bz(12, this.Scene);
      AppMethodBeat.o(152705);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.usl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlq localdlq = (dlq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152705);
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
            localdlq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 2: 
          localdlq.FZa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 3: 
          localdlq.GbY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152705);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlq.usl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 5: 
          localdlq.HTb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152705);
          return 0;
        case 6: 
          localdlq.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 7: 
          localdlq.FZk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152705);
          return 0;
        case 8: 
          localdlq.HSW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152705);
          return 0;
        case 9: 
          localdlq.HTc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 10: 
          localdlq.Buffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(152705);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlq.HTd = ((clv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        }
        localdlq.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152705);
        return 0;
      }
      AppMethodBeat.o(152705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlq
 * JD-Core Version:    0.7.0.1
 */