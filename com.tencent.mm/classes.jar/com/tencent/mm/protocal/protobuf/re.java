package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class re
  extends com.tencent.mm.bw.a
{
  public String DMR;
  public String EiF;
  public int EiQ;
  public String EiR;
  public rm EiS;
  public String EiT;
  public String Ejs;
  public String dvO;
  public int lRv;
  public String nVK;
  public String oGN;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvO != null) {
        paramVarArgs.d(1, this.dvO);
      }
      if (this.DMR != null) {
        paramVarArgs.d(2, this.DMR);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.nVK != null) {
        paramVarArgs.d(4, this.nVK);
      }
      if (this.Ejs != null) {
        paramVarArgs.d(5, this.Ejs);
      }
      if (this.EiF != null) {
        paramVarArgs.d(6, this.EiF);
      }
      paramVarArgs.aR(7, this.lRv);
      if (this.oGN != null) {
        paramVarArgs.d(8, this.oGN);
      }
      paramVarArgs.aR(9, this.EiQ);
      if (this.EiR != null) {
        paramVarArgs.d(10, this.EiR);
      }
      if (this.EiS != null)
      {
        paramVarArgs.ln(11, this.EiS.computeSize());
        this.EiS.writeFields(paramVarArgs);
      }
      if (this.EiT != null) {
        paramVarArgs.d(12, this.EiT);
      }
      AppMethodBeat.o(206446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvO == null) {
        break label954;
      }
    }
    label954:
    for (int i = f.a.a.b.b.a.e(1, this.dvO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DMR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DMR);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.nVK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nVK);
      }
      i = paramInt;
      if (this.Ejs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ejs);
      }
      paramInt = i;
      if (this.EiF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EiF);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.lRv);
      paramInt = i;
      if (this.oGN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.oGN);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.EiQ);
      paramInt = i;
      if (this.EiR != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.EiR);
      }
      i = paramInt;
      if (this.EiS != null) {
        i = paramInt + f.a.a.a.lm(11, this.EiS.computeSize());
      }
      paramInt = i;
      if (this.EiT != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EiT);
      }
      AppMethodBeat.o(206446);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(206446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        re localre = (re)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206446);
          return -1;
        case 1: 
          localre.dvO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206446);
          return 0;
        case 2: 
          localre.DMR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206446);
          return 0;
        case 3: 
          localre.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206446);
          return 0;
        case 4: 
          localre.nVK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206446);
          return 0;
        case 5: 
          localre.Ejs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206446);
          return 0;
        case 6: 
          localre.EiF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206446);
          return 0;
        case 7: 
          localre.lRv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206446);
          return 0;
        case 8: 
          localre.oGN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206446);
          return 0;
        case 9: 
          localre.EiQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206446);
          return 0;
        case 10: 
          localre.EiR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206446);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localre.EiS = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206446);
          return 0;
        }
        localre.EiT = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(206446);
        return 0;
      }
      AppMethodBeat.o(206446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.re
 * JD-Core Version:    0.7.0.1
 */