package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dfi
  extends cpx
{
  public b Buffer;
  public String EaV;
  public int Ebf;
  public int Edq;
  public int FOA;
  public int FOF;
  public String FOG;
  public cgc FOH;
  public int Scene;
  public String hOf;
  public LinkedList<dfh> tiT;
  
  public dfi()
  {
    AppMethodBeat.i(152704);
    this.tiT = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EaV != null) {
        paramVarArgs.d(2, this.EaV);
      }
      paramVarArgs.aR(3, this.Edq);
      paramVarArgs.e(4, 8, this.tiT);
      paramVarArgs.aR(5, this.FOF);
      if (this.hOf != null) {
        paramVarArgs.d(6, this.hOf);
      }
      paramVarArgs.aR(7, this.Ebf);
      paramVarArgs.aR(8, this.FOA);
      if (this.FOG != null) {
        paramVarArgs.d(9, this.FOG);
      }
      if (this.Buffer != null) {
        paramVarArgs.c(10, this.Buffer);
      }
      if (this.FOH != null)
      {
        paramVarArgs.ln(11, this.FOH.computeSize());
        this.FOH.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.Scene);
      AppMethodBeat.o(152705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1074;
      }
    }
    label1074:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EaV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EaV);
      }
      i = i + f.a.a.b.b.a.bx(3, this.Edq) + f.a.a.a.c(4, 8, this.tiT) + f.a.a.b.b.a.bx(5, this.FOF);
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hOf);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.Ebf) + f.a.a.b.b.a.bx(8, this.FOA);
      paramInt = i;
      if (this.FOG != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FOG);
      }
      i = paramInt;
      if (this.Buffer != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.Buffer);
      }
      paramInt = i;
      if (this.FOH != null) {
        paramInt = i + f.a.a.a.lm(11, this.FOH.computeSize());
      }
      i = f.a.a.b.b.a.bx(12, this.Scene);
      AppMethodBeat.o(152705);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tiT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfi localdfi = (dfi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152705);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfi.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 2: 
          localdfi.EaV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 3: 
          localdfi.Edq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152705);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfi.tiT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 5: 
          localdfi.FOF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152705);
          return 0;
        case 6: 
          localdfi.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 7: 
          localdfi.Ebf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152705);
          return 0;
        case 8: 
          localdfi.FOA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152705);
          return 0;
        case 9: 
          localdfi.FOG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 10: 
          localdfi.Buffer = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(152705);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfi.FOH = ((cgc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        }
        localdfi.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152705);
        return 0;
      }
      AppMethodBeat.o(152705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfi
 * JD-Core Version:    0.7.0.1
 */