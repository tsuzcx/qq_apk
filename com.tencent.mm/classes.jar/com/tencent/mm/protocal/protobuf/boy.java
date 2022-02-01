package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class boy
  extends com.tencent.mm.bw.a
{
  public int FeA;
  public int FeB;
  public String Fey;
  public SKBuiltinBuffer_t Fez;
  public String Title;
  public int ndI;
  public float vkA;
  public String vkB;
  public SKBuiltinBuffer_t vkC;
  public String vku;
  public float vkv;
  public int vkw;
  public LinkedList<Integer> vkx;
  public int vky;
  public LinkedList<crm> vkz;
  
  public boy()
  {
    AppMethodBeat.i(116338);
    this.vkx = new LinkedList();
    this.vkz = new LinkedList();
    AppMethodBeat.o(116338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116339);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vku != null) {
        paramVarArgs.d(1, this.vku);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.x(3, this.vkv);
      paramVarArgs.aR(4, this.vkw);
      paramVarArgs.f(5, 2, this.vkx);
      paramVarArgs.aR(6, this.vky);
      paramVarArgs.e(7, 8, this.vkz);
      paramVarArgs.x(8, this.vkA);
      if (this.vkB != null) {
        paramVarArgs.d(9, this.vkB);
      }
      paramVarArgs.aR(10, this.ndI);
      if (this.vkC != null)
      {
        paramVarArgs.ln(11, this.vkC.computeSize());
        this.vkC.writeFields(paramVarArgs);
      }
      if (this.Fey != null) {
        paramVarArgs.d(12, this.Fey);
      }
      if (this.Fez != null)
      {
        paramVarArgs.ln(13, this.Fez.computeSize());
        this.Fez.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.FeA);
      paramVarArgs.aR(15, this.FeB);
      AppMethodBeat.o(116339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vku == null) {
        break label1239;
      }
    }
    label1239:
    for (paramInt = f.a.a.b.b.a.e(1, this.vku) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      i = i + (f.a.a.b.b.a.fK(3) + 4) + f.a.a.b.b.a.bx(4, this.vkw) + f.a.a.a.d(5, 2, this.vkx) + f.a.a.b.b.a.bx(6, this.vky) + f.a.a.a.c(7, 8, this.vkz) + (f.a.a.b.b.a.fK(8) + 4);
      paramInt = i;
      if (this.vkB != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.vkB);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.ndI);
      paramInt = i;
      if (this.vkC != null) {
        paramInt = i + f.a.a.a.lm(11, this.vkC.computeSize());
      }
      i = paramInt;
      if (this.Fey != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Fey);
      }
      paramInt = i;
      if (this.Fez != null) {
        paramInt = i + f.a.a.a.lm(13, this.Fez.computeSize());
      }
      i = f.a.a.b.b.a.bx(14, this.FeA);
      int j = f.a.a.b.b.a.bx(15, this.FeB);
      AppMethodBeat.o(116339);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vkx.clear();
        this.vkz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        boy localboy = (boy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116339);
          return -1;
        case 1: 
          localboy.vku = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 2: 
          localboy.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 3: 
          localboy.vkv = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(116339);
          return 0;
        case 4: 
          localboy.vkw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(116339);
          return 0;
        case 5: 
          localboy.vkx = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
          AppMethodBeat.o(116339);
          return 0;
        case 6: 
          localboy.vky = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(116339);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboy.vkz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 8: 
          localboy.vkA = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(116339);
          return 0;
        case 9: 
          localboy.vkB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 10: 
          localboy.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(116339);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboy.vkC = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 12: 
          localboy.Fey = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboy.Fez = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 14: 
          localboy.FeA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(116339);
          return 0;
        }
        localboy.FeB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(116339);
        return 0;
      }
      AppMethodBeat.o(116339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boy
 * JD-Core Version:    0.7.0.1
 */