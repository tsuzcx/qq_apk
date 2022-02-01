package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class buf
  extends com.tencent.mm.bw.a
{
  public String HhC;
  public SKBuiltinBuffer_t HhD;
  public int HhE;
  public int HhF;
  public String Title;
  public int nJA;
  public LinkedList<cxn> wFA;
  public float wFB;
  public String wFC;
  public SKBuiltinBuffer_t wFD;
  public String wFv;
  public float wFw;
  public int wFx;
  public LinkedList<Integer> wFy;
  public int wFz;
  
  public buf()
  {
    AppMethodBeat.i(116338);
    this.wFy = new LinkedList();
    this.wFA = new LinkedList();
    AppMethodBeat.o(116338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116339);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wFv != null) {
        paramVarArgs.d(1, this.wFv);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.y(3, this.wFw);
      paramVarArgs.aS(4, this.wFx);
      paramVarArgs.f(5, 2, this.wFy);
      paramVarArgs.aS(6, this.wFz);
      paramVarArgs.e(7, 8, this.wFA);
      paramVarArgs.y(8, this.wFB);
      if (this.wFC != null) {
        paramVarArgs.d(9, this.wFC);
      }
      paramVarArgs.aS(10, this.nJA);
      if (this.wFD != null)
      {
        paramVarArgs.lJ(11, this.wFD.computeSize());
        this.wFD.writeFields(paramVarArgs);
      }
      if (this.HhC != null) {
        paramVarArgs.d(12, this.HhC);
      }
      if (this.HhD != null)
      {
        paramVarArgs.lJ(13, this.HhD.computeSize());
        this.HhD.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.HhE);
      paramVarArgs.aS(15, this.HhF);
      AppMethodBeat.o(116339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wFv == null) {
        break label1235;
      }
    }
    label1235:
    for (paramInt = f.a.a.b.b.a.e(1, this.wFv) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      i = i + f.a.a.b.b.a.amE(3) + f.a.a.b.b.a.bz(4, this.wFx) + f.a.a.a.d(5, 2, this.wFy) + f.a.a.b.b.a.bz(6, this.wFz) + f.a.a.a.c(7, 8, this.wFA) + f.a.a.b.b.a.amE(8);
      paramInt = i;
      if (this.wFC != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.wFC);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.nJA);
      paramInt = i;
      if (this.wFD != null) {
        paramInt = i + f.a.a.a.lI(11, this.wFD.computeSize());
      }
      i = paramInt;
      if (this.HhC != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HhC);
      }
      paramInt = i;
      if (this.HhD != null) {
        paramInt = i + f.a.a.a.lI(13, this.HhD.computeSize());
      }
      i = f.a.a.b.b.a.bz(14, this.HhE);
      int j = f.a.a.b.b.a.bz(15, this.HhF);
      AppMethodBeat.o(116339);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wFy.clear();
        this.wFA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        buf localbuf = (buf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116339);
          return -1;
        case 1: 
          localbuf.wFv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 2: 
          localbuf.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 3: 
          localbuf.wFw = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(116339);
          return 0;
        case 4: 
          localbuf.wFx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116339);
          return 0;
        case 5: 
          localbuf.wFy = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
          AppMethodBeat.o(116339);
          return 0;
        case 6: 
          localbuf.wFz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116339);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuf.wFA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 8: 
          localbuf.wFB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(116339);
          return 0;
        case 9: 
          localbuf.wFC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 10: 
          localbuf.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116339);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuf.wFD = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 12: 
          localbuf.HhC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuf.HhD = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 14: 
          localbuf.HhE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116339);
          return 0;
        }
        localbuf.HhF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(116339);
        return 0;
      }
      AppMethodBeat.o(116339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buf
 * JD-Core Version:    0.7.0.1
 */