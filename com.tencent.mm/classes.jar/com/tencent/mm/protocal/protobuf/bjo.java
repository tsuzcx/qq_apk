package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bjo
  extends cvw
{
  public String FSg;
  public SKBuiltinBuffer_t FWl;
  public String GWW;
  public String GWX;
  public String GWY;
  public String GWZ;
  public String GXa;
  public int GXb;
  public String nJO;
  public String qkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155417);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWl == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155417);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FWl != null)
      {
        paramVarArgs.lJ(2, this.FWl.computeSize());
        this.FWl.writeFields(paramVarArgs);
      }
      if (this.GWW != null) {
        paramVarArgs.d(3, this.GWW);
      }
      if (this.GWX != null) {
        paramVarArgs.d(4, this.GWX);
      }
      if (this.nJO != null) {
        paramVarArgs.d(5, this.nJO);
      }
      if (this.GWY != null) {
        paramVarArgs.d(6, this.GWY);
      }
      if (this.GWZ != null) {
        paramVarArgs.d(7, this.GWZ);
      }
      if (this.GXa != null) {
        paramVarArgs.d(8, this.GXa);
      }
      paramVarArgs.aS(9, this.GXb);
      if (this.qkN != null) {
        paramVarArgs.d(10, this.qkN);
      }
      if (this.FSg != null) {
        paramVarArgs.d(11, this.FSg);
      }
      AppMethodBeat.o(155417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1050;
      }
    }
    label1050:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FWl != null) {
        paramInt = i + f.a.a.a.lI(2, this.FWl.computeSize());
      }
      i = paramInt;
      if (this.GWW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GWW);
      }
      paramInt = i;
      if (this.GWX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GWX);
      }
      i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nJO);
      }
      paramInt = i;
      if (this.GWY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GWY);
      }
      i = paramInt;
      if (this.GWZ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GWZ);
      }
      paramInt = i;
      if (this.GXa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GXa);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GXb);
      paramInt = i;
      if (this.qkN != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qkN);
      }
      i = paramInt;
      if (this.FSg != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FSg);
      }
      AppMethodBeat.o(155417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FWl == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjo localbjo = (bjo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155417);
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
            localbjo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
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
            localbjo.FWl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 3: 
          localbjo.GWW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 4: 
          localbjo.GWX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 5: 
          localbjo.nJO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 6: 
          localbjo.GWY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 7: 
          localbjo.GWZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 8: 
          localbjo.GXa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 9: 
          localbjo.GXb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155417);
          return 0;
        case 10: 
          localbjo.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155417);
          return 0;
        }
        localbjo.FSg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155417);
        return 0;
      }
      AppMethodBeat.o(155417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjo
 * JD-Core Version:    0.7.0.1
 */