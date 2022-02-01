package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cmp
  extends com.tencent.mm.bw.a
{
  public String Fdk;
  public int FzP;
  public String FzQ;
  public String FzR;
  public String FzS;
  public String FzT;
  public bic FzU;
  public String FzV;
  public String FzW;
  public String lRr;
  public String lRs;
  public String lRt;
  public String lRu;
  public int lRv;
  public String lRw;
  public String oGU;
  public double score;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50101);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.lRv);
      paramVarArgs.aR(2, this.FzP);
      if (this.Fdk != null) {
        paramVarArgs.d(3, this.Fdk);
      }
      if (this.lRt != null) {
        paramVarArgs.d(4, this.lRt);
      }
      if (this.lRu != null) {
        paramVarArgs.d(5, this.lRu);
      }
      if (this.FzQ != null) {
        paramVarArgs.d(6, this.FzQ);
      }
      if (this.oGU != null) {
        paramVarArgs.d(7, this.oGU);
      }
      if (this.FzR != null) {
        paramVarArgs.d(8, this.FzR);
      }
      if (this.FzS != null) {
        paramVarArgs.d(9, this.FzS);
      }
      paramVarArgs.e(10, this.score);
      if (this.FzT != null) {
        paramVarArgs.d(11, this.FzT);
      }
      if (this.lRr != null) {
        paramVarArgs.d(12, this.lRr);
      }
      if (this.FzU != null)
      {
        paramVarArgs.ln(14, this.FzU.computeSize());
        this.FzU.writeFields(paramVarArgs);
      }
      if (this.lRs != null) {
        paramVarArgs.d(15, this.lRs);
      }
      if (this.FzV != null) {
        paramVarArgs.d(16, this.FzV);
      }
      if (this.FzW != null) {
        paramVarArgs.d(17, this.FzW);
      }
      if (this.lRw != null) {
        paramVarArgs.d(18, this.lRw);
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.lRv) + 0 + f.a.a.b.b.a.bx(2, this.FzP);
      paramInt = i;
      if (this.Fdk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Fdk);
      }
      i = paramInt;
      if (this.lRt != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.lRt);
      }
      paramInt = i;
      if (this.lRu != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.lRu);
      }
      i = paramInt;
      if (this.FzQ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FzQ);
      }
      paramInt = i;
      if (this.oGU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.oGU);
      }
      i = paramInt;
      if (this.FzR != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FzR);
      }
      paramInt = i;
      if (this.FzS != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FzS);
      }
      i = paramInt + (f.a.a.b.b.a.fK(10) + 8);
      paramInt = i;
      if (this.FzT != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FzT);
      }
      i = paramInt;
      if (this.lRr != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.lRr);
      }
      paramInt = i;
      if (this.FzU != null) {
        paramInt = i + f.a.a.a.lm(14, this.FzU.computeSize());
      }
      i = paramInt;
      if (this.lRs != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.lRs);
      }
      paramInt = i;
      if (this.FzV != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FzV);
      }
      i = paramInt;
      if (this.FzW != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.FzW);
      }
      paramInt = i;
      if (this.lRw != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.lRw);
      }
      AppMethodBeat.o(50101);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cmp localcmp = (cmp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(50101);
        return -1;
      case 1: 
        localcmp.lRv = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(50101);
        return 0;
      case 2: 
        localcmp.FzP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(50101);
        return 0;
      case 3: 
        localcmp.Fdk = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 4: 
        localcmp.lRt = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 5: 
        localcmp.lRu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 6: 
        localcmp.FzQ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 7: 
        localcmp.oGU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 8: 
        localcmp.FzR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 9: 
        localcmp.FzS = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 10: 
        localcmp.score = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
        AppMethodBeat.o(50101);
        return 0;
      case 11: 
        localcmp.FzT = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 12: 
        localcmp.lRr = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bic();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bic)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmp.FzU = ((bic)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50101);
        return 0;
      case 15: 
        localcmp.lRs = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 16: 
        localcmp.FzV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 17: 
        localcmp.FzW = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50101);
        return 0;
      }
      localcmp.lRw = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(50101);
      return 0;
    }
    AppMethodBeat.o(50101);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmp
 * JD-Core Version:    0.7.0.1
 */