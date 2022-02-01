package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class arj
  extends cpx
{
  public int DSv;
  public int DUB;
  public int DXj;
  public LinkedList<b> EKA;
  public int EKx;
  public String EKy;
  public LinkedList<ari> EKz;
  public int Scene;
  public String nOG;
  
  public arj()
  {
    AppMethodBeat.i(152547);
    this.EKz = new LinkedList();
    this.EKA = new LinkedList();
    AppMethodBeat.o(152547);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152548);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DXj);
      paramVarArgs.aR(3, this.Scene);
      paramVarArgs.aR(4, this.DUB);
      paramVarArgs.aR(5, this.EKx);
      if (this.nOG != null) {
        paramVarArgs.d(6, this.nOG);
      }
      if (this.EKy != null) {
        paramVarArgs.d(7, this.EKy);
      }
      paramVarArgs.aR(8, this.DSv);
      paramVarArgs.e(9, 8, this.EKz);
      paramVarArgs.e(10, 6, this.EKA);
      AppMethodBeat.o(152548);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DXj) + f.a.a.b.b.a.bx(3, this.Scene) + f.a.a.b.b.a.bx(4, this.DUB) + f.a.a.b.b.a.bx(5, this.EKx);
      paramInt = i;
      if (this.nOG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.nOG);
      }
      i = paramInt;
      if (this.EKy != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EKy);
      }
      paramInt = f.a.a.b.b.a.bx(8, this.DSv);
      int j = f.a.a.a.c(9, 8, this.EKz);
      int k = f.a.a.a.c(10, 6, this.EKA);
      AppMethodBeat.o(152548);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EKz.clear();
        this.EKA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152548);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arj localarj = (arj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152548);
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
            localarj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        case 2: 
          localarj.DXj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152548);
          return 0;
        case 3: 
          localarj.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152548);
          return 0;
        case 4: 
          localarj.DUB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152548);
          return 0;
        case 5: 
          localarj.EKx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152548);
          return 0;
        case 6: 
          localarj.nOG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 7: 
          localarj.EKy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 8: 
          localarj.DSv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152548);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ari();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ari)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarj.EKz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        }
        localarj.EKA.add(((f.a.a.a.a)localObject1).LVo.gfk());
        AppMethodBeat.o(152548);
        return 0;
      }
      AppMethodBeat.o(152548);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arj
 * JD-Core Version:    0.7.0.1
 */