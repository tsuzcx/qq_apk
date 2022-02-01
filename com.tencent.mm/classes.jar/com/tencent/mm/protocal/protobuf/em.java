package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class em
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String DPY;
  public int DRa;
  public String DRb;
  public SKBuiltinBuffer_t DRc;
  public int DRd;
  public String DRe;
  public String DRf;
  public String DRg;
  public int DRh;
  public String hOf;
  public String hkR;
  public int ndI;
  public int sVo;
  public String thr;
  public String tlJ;
  public String tlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32116);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlK != null) {
        paramVarArgs.d(1, this.tlK);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      paramVarArgs.aR(3, this.DRa);
      if (this.tlJ != null) {
        paramVarArgs.d(4, this.tlJ);
      }
      paramVarArgs.aR(5, this.ndI);
      if (this.hkR != null) {
        paramVarArgs.d(6, this.hkR);
      }
      paramVarArgs.aR(7, this.CreateTime);
      if (this.DRb != null) {
        paramVarArgs.d(8, this.DRb);
      }
      if (this.DRc != null)
      {
        paramVarArgs.ln(9, this.DRc.computeSize());
        this.DRc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.sVo);
      paramVarArgs.aR(11, this.DRd);
      if (this.DPY != null) {
        paramVarArgs.d(12, this.DPY);
      }
      if (this.DRe != null) {
        paramVarArgs.d(13, this.DRe);
      }
      if (this.DRf != null) {
        paramVarArgs.d(14, this.DRf);
      }
      if (this.DRg != null) {
        paramVarArgs.d(15, this.DRg);
      }
      paramVarArgs.aR(16, this.DRh);
      if (this.thr != null) {
        paramVarArgs.d(17, this.thr);
      }
      AppMethodBeat.o(32116);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlK == null) {
        break label1221;
      }
    }
    label1221:
    for (paramInt = f.a.a.b.b.a.e(1, this.tlK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hOf);
      }
      i += f.a.a.b.b.a.bx(3, this.DRa);
      paramInt = i;
      if (this.tlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tlJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.ndI);
      paramInt = i;
      if (this.hkR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hkR);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.CreateTime);
      paramInt = i;
      if (this.DRb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DRb);
      }
      i = paramInt;
      if (this.DRc != null) {
        i = paramInt + f.a.a.a.lm(9, this.DRc.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(10, this.sVo) + f.a.a.b.b.a.bx(11, this.DRd);
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DPY);
      }
      i = paramInt;
      if (this.DRe != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DRe);
      }
      paramInt = i;
      if (this.DRf != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DRf);
      }
      i = paramInt;
      if (this.DRg != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DRg);
      }
      i += f.a.a.b.b.a.bx(16, this.DRh);
      paramInt = i;
      if (this.thr != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.thr);
      }
      AppMethodBeat.o(32116);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32116);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        em localem = (em)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32116);
          return -1;
        case 1: 
          localem.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 2: 
          localem.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 3: 
          localem.DRa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32116);
          return 0;
        case 4: 
          localem.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 5: 
          localem.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32116);
          return 0;
        case 6: 
          localem.hkR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 7: 
          localem.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32116);
          return 0;
        case 8: 
          localem.DRb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localem.DRc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32116);
          return 0;
        case 10: 
          localem.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32116);
          return 0;
        case 11: 
          localem.DRd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32116);
          return 0;
        case 12: 
          localem.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 13: 
          localem.DRe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 14: 
          localem.DRf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 15: 
          localem.DRg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 16: 
          localem.DRh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32116);
          return 0;
        }
        localem.thr = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32116);
        return 0;
      }
      AppMethodBeat.o(32116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.em
 * JD-Core Version:    0.7.0.1
 */