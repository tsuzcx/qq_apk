package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyy
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String DSu;
  public int ETI;
  public int EfV;
  public int FIg;
  public String FIh;
  public int FhS;
  public bpa FhT;
  public String FhW;
  public String FrP;
  public String Md5;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      paramVarArgs.aR(2, this.EfV);
      paramVarArgs.aR(3, this.Scene);
      if (this.FhW != null) {
        paramVarArgs.d(4, this.FhW);
      }
      if (this.DSu != null) {
        paramVarArgs.d(5, this.DSu);
      }
      paramVarArgs.aR(6, this.FhS);
      if (this.FhT != null)
      {
        paramVarArgs.ln(7, this.FhT.computeSize());
        this.FhT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.FIg);
      if (this.FrP != null) {
        paramVarArgs.d(9, this.FrP);
      }
      paramVarArgs.aR(10, this.ETI);
      if (this.FIh != null) {
        paramVarArgs.d(11, this.FIh);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(12, this.AesKey);
      }
      AppMethodBeat.o(117925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = f.a.a.b.b.a.e(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EfV) + f.a.a.b.b.a.bx(3, this.Scene);
      paramInt = i;
      if (this.FhW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FhW);
      }
      i = paramInt;
      if (this.DSu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DSu);
      }
      i += f.a.a.b.b.a.bx(6, this.FhS);
      paramInt = i;
      if (this.FhT != null) {
        paramInt = i + f.a.a.a.lm(7, this.FhT.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.FIg);
      paramInt = i;
      if (this.FrP != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FrP);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.ETI);
      paramInt = i;
      if (this.FIh != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FIh);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.AesKey);
      }
      AppMethodBeat.o(117925);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyy localcyy = (cyy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117925);
          return -1;
        case 1: 
          localcyy.Md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 2: 
          localcyy.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117925);
          return 0;
        case 3: 
          localcyy.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117925);
          return 0;
        case 4: 
          localcyy.FhW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 5: 
          localcyy.DSu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 6: 
          localcyy.FhS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117925);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyy.FhT = ((bpa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117925);
          return 0;
        case 8: 
          localcyy.FIg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117925);
          return 0;
        case 9: 
          localcyy.FrP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 10: 
          localcyy.ETI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117925);
          return 0;
        case 11: 
          localcyy.FIh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117925);
          return 0;
        }
        localcyy.AesKey = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117925);
        return 0;
      }
      AppMethodBeat.o(117925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyy
 * JD-Core Version:    0.7.0.1
 */