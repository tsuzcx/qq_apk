package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String gTA;
  public String gTB;
  public long gTC;
  public k gTD;
  public String gTE;
  public String gTF;
  public String gTG;
  public String gTH;
  public String gTI = "fa5151";
  public String gTJ = "ffffff";
  public String gTK = "f2f2f2";
  public String gTL = "fa5151";
  public String gTM = "C84040";
  public int gTr;
  public String gTs;
  public String gTt;
  public int gTu;
  public l gTv;
  public String gTw;
  public int gTx;
  public l gTy;
  public int gTz;
  public String nickname;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194682);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.gTr);
      if (this.gTs != null) {
        paramVarArgs.e(2, this.gTs);
      }
      if (this.nickname != null) {
        paramVarArgs.e(3, this.nickname);
      }
      if (this.title != null) {
        paramVarArgs.e(4, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(5, this.desc);
      }
      if (this.gTt != null) {
        paramVarArgs.e(7, this.gTt);
      }
      paramVarArgs.aM(8, this.gTu);
      if (this.gTv != null)
      {
        paramVarArgs.ni(9, this.gTv.computeSize());
        this.gTv.writeFields(paramVarArgs);
      }
      if (this.gTw != null) {
        paramVarArgs.e(10, this.gTw);
      }
      paramVarArgs.aM(11, this.gTx);
      if (this.gTy != null)
      {
        paramVarArgs.ni(12, this.gTy.computeSize());
        this.gTy.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.gTz);
      if (this.gTA != null) {
        paramVarArgs.e(15, this.gTA);
      }
      if (this.gTB != null) {
        paramVarArgs.e(16, this.gTB);
      }
      paramVarArgs.bb(19, this.gTC);
      if (this.gTD != null)
      {
        paramVarArgs.ni(25, this.gTD.computeSize());
        this.gTD.writeFields(paramVarArgs);
      }
      if (this.gTE != null) {
        paramVarArgs.e(6, this.gTE);
      }
      if (this.gTF != null) {
        paramVarArgs.e(13, this.gTF);
      }
      if (this.gTG != null) {
        paramVarArgs.e(17, this.gTG);
      }
      if (this.gTH != null) {
        paramVarArgs.e(18, this.gTH);
      }
      if (this.gTI != null) {
        paramVarArgs.e(20, this.gTI);
      }
      if (this.gTJ != null) {
        paramVarArgs.e(21, this.gTJ);
      }
      if (this.gTK != null) {
        paramVarArgs.e(22, this.gTK);
      }
      if (this.gTL != null) {
        paramVarArgs.e(23, this.gTL);
      }
      if (this.gTM != null) {
        paramVarArgs.e(24, this.gTM);
      }
      AppMethodBeat.o(194682);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.gTr) + 0;
      paramInt = i;
      if (this.gTs != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.gTs);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.nickname);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.desc);
      }
      paramInt = i;
      if (this.gTt != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.gTt);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.gTu);
      paramInt = i;
      if (this.gTv != null) {
        paramInt = i + g.a.a.a.nh(9, this.gTv.computeSize());
      }
      i = paramInt;
      if (this.gTw != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.gTw);
      }
      i += g.a.a.b.b.a.bu(11, this.gTx);
      paramInt = i;
      if (this.gTy != null) {
        paramInt = i + g.a.a.a.nh(12, this.gTy.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.gTz);
      paramInt = i;
      if (this.gTA != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.gTA);
      }
      i = paramInt;
      if (this.gTB != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.gTB);
      }
      i += g.a.a.b.b.a.r(19, this.gTC);
      paramInt = i;
      if (this.gTD != null) {
        paramInt = i + g.a.a.a.nh(25, this.gTD.computeSize());
      }
      i = paramInt;
      if (this.gTE != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.gTE);
      }
      paramInt = i;
      if (this.gTF != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.gTF);
      }
      i = paramInt;
      if (this.gTG != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.gTG);
      }
      paramInt = i;
      if (this.gTH != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.gTH);
      }
      i = paramInt;
      if (this.gTI != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.gTI);
      }
      paramInt = i;
      if (this.gTJ != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.gTJ);
      }
      i = paramInt;
      if (this.gTK != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.gTK);
      }
      paramInt = i;
      if (this.gTL != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.gTL);
      }
      i = paramInt;
      if (this.gTM != null) {
        i = paramInt + g.a.a.b.b.a.f(24, this.gTM);
      }
      AppMethodBeat.o(194682);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(194682);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(194682);
        return -1;
      case 1: 
        localj.gTr = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194682);
        return 0;
      case 2: 
        localj.gTs = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 3: 
        localj.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 4: 
        localj.title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 5: 
        localj.desc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 7: 
        localj.gTt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 8: 
        localj.gTu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194682);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localj.gTv = ((l)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194682);
        return 0;
      case 10: 
        localj.gTw = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 11: 
        localj.gTx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194682);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localj.gTy = ((l)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194682);
        return 0;
      case 14: 
        localj.gTz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(194682);
        return 0;
      case 15: 
        localj.gTA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 16: 
        localj.gTB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 19: 
        localj.gTC = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(194682);
        return 0;
      case 25: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localj.gTD = ((k)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194682);
        return 0;
      case 6: 
        localj.gTE = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 13: 
        localj.gTF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 17: 
        localj.gTG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 18: 
        localj.gTH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 20: 
        localj.gTI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 21: 
        localj.gTJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 22: 
        localj.gTK = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      case 23: 
        localj.gTL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(194682);
        return 0;
      }
      localj.gTM = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(194682);
      return 0;
    }
    AppMethodBeat.o(194682);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.t.a.j
 * JD-Core Version:    0.7.0.1
 */