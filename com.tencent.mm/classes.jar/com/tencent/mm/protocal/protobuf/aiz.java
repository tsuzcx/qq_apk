package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aiz
  extends com.tencent.mm.bw.a
{
  public int BsF;
  public int BsG;
  public String KHq;
  public String LbN;
  public String LsA;
  public String LsB;
  public int LsC;
  public SKBuiltinBuffer_t Lsy;
  public String Lsz;
  public String MD5;
  public int oUv;
  public String xNG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109446);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lsy == null)
      {
        paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(109446);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.e(1, this.MD5);
      }
      paramVarArgs.aM(2, this.BsG);
      paramVarArgs.aM(3, this.BsF);
      if (this.Lsy != null)
      {
        paramVarArgs.ni(4, this.Lsy.computeSize());
        this.Lsy.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.oUv);
      if (this.xNG != null) {
        paramVarArgs.e(6, this.xNG);
      }
      if (this.Lsz != null) {
        paramVarArgs.e(7, this.Lsz);
      }
      if (this.LsA != null) {
        paramVarArgs.e(8, this.LsA);
      }
      if (this.LsB != null) {
        paramVarArgs.e(9, this.LsB);
      }
      if (this.KHq != null) {
        paramVarArgs.e(10, this.KHq);
      }
      paramVarArgs.aM(11, this.LsC);
      if (this.LbN != null) {
        paramVarArgs.e(12, this.LbN);
      }
      AppMethodBeat.o(109446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label966;
      }
    }
    label966:
    for (paramInt = g.a.a.b.b.a.f(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
      paramInt = i;
      if (this.Lsy != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lsy.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.oUv);
      paramInt = i;
      if (this.xNG != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xNG);
      }
      i = paramInt;
      if (this.Lsz != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lsz);
      }
      paramInt = i;
      if (this.LsA != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LsA);
      }
      i = paramInt;
      if (this.LsB != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LsB);
      }
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KHq);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.LsC);
      paramInt = i;
      if (this.LbN != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.LbN);
      }
      AppMethodBeat.o(109446);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lsy == null)
        {
          paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(109446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(109446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aiz localaiz = (aiz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(109446);
          return -1;
        case 1: 
          localaiz.MD5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 2: 
          localaiz.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(109446);
          return 0;
        case 3: 
          localaiz.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(109446);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaiz.Lsy = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(109446);
          return 0;
        case 5: 
          localaiz.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(109446);
          return 0;
        case 6: 
          localaiz.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 7: 
          localaiz.Lsz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 8: 
          localaiz.LsA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 9: 
          localaiz.LsB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 10: 
          localaiz.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 11: 
          localaiz.LsC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(109446);
          return 0;
        }
        localaiz.LbN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(109446);
        return 0;
      }
      AppMethodBeat.o(109446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiz
 * JD-Core Version:    0.7.0.1
 */