package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adp
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int LoU;
  public LinkedList<cnb> LoV;
  public int LoW;
  public String LoX;
  public cli LoY;
  public bcl LoZ;
  public jo Lpa;
  public bcf Lpb;
  public axf Lpc;
  public col Lpd;
  public bcl Lpe;
  public String Title;
  public String Url;
  public bcj dME;
  public int izD;
  public css jfy;
  
  public adp()
  {
    AppMethodBeat.i(125718);
    this.LoV = new LinkedList();
    AppMethodBeat.o(125718);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125719);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Desc != null) {
        paramVarArgs.e(1, this.Desc);
      }
      paramVarArgs.aM(2, this.LoU);
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.e(4, this.Url);
      }
      paramVarArgs.e(5, 8, this.LoV);
      paramVarArgs.aM(6, this.LoW);
      if (this.LoX != null) {
        paramVarArgs.e(7, this.LoX);
      }
      if (this.LoY != null)
      {
        paramVarArgs.ni(8, this.LoY.computeSize());
        this.LoY.writeFields(paramVarArgs);
      }
      if (this.dME != null)
      {
        paramVarArgs.ni(9, this.dME.computeSize());
        this.dME.writeFields(paramVarArgs);
      }
      if (this.LoZ != null)
      {
        paramVarArgs.ni(10, this.LoZ.computeSize());
        this.LoZ.writeFields(paramVarArgs);
      }
      if (this.Lpa != null)
      {
        paramVarArgs.ni(11, this.Lpa.computeSize());
        this.Lpa.writeFields(paramVarArgs);
      }
      if (this.Lpb != null)
      {
        paramVarArgs.ni(12, this.Lpb.computeSize());
        this.Lpb.writeFields(paramVarArgs);
      }
      if (this.Lpc != null)
      {
        paramVarArgs.ni(13, this.Lpc.computeSize());
        this.Lpc.writeFields(paramVarArgs);
      }
      if (this.Lpd != null)
      {
        paramVarArgs.ni(14, this.Lpd.computeSize());
        this.Lpd.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(15, this.izD);
      if (this.Lpe != null)
      {
        paramVarArgs.ni(16, this.Lpe.computeSize());
        this.Lpe.writeFields(paramVarArgs);
      }
      if (this.jfy != null)
      {
        paramVarArgs.ni(17, this.jfy.computeSize());
        this.jfy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Desc == null) {
        break label2078;
      }
    }
    label2078:
    for (paramInt = g.a.a.b.b.a.f(1, this.Desc) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LoU);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Title);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Url);
      }
      i = i + g.a.a.a.c(5, 8, this.LoV) + g.a.a.b.b.a.bu(6, this.LoW);
      paramInt = i;
      if (this.LoX != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LoX);
      }
      i = paramInt;
      if (this.LoY != null) {
        i = paramInt + g.a.a.a.nh(8, this.LoY.computeSize());
      }
      paramInt = i;
      if (this.dME != null) {
        paramInt = i + g.a.a.a.nh(9, this.dME.computeSize());
      }
      i = paramInt;
      if (this.LoZ != null) {
        i = paramInt + g.a.a.a.nh(10, this.LoZ.computeSize());
      }
      paramInt = i;
      if (this.Lpa != null) {
        paramInt = i + g.a.a.a.nh(11, this.Lpa.computeSize());
      }
      i = paramInt;
      if (this.Lpb != null) {
        i = paramInt + g.a.a.a.nh(12, this.Lpb.computeSize());
      }
      paramInt = i;
      if (this.Lpc != null) {
        paramInt = i + g.a.a.a.nh(13, this.Lpc.computeSize());
      }
      i = paramInt;
      if (this.Lpd != null) {
        i = paramInt + g.a.a.a.nh(14, this.Lpd.computeSize());
      }
      i += g.a.a.b.b.a.bu(15, this.izD);
      paramInt = i;
      if (this.Lpe != null) {
        paramInt = i + g.a.a.a.nh(16, this.Lpe.computeSize());
      }
      i = paramInt;
      if (this.jfy != null) {
        i = paramInt + g.a.a.a.nh(17, this.jfy.computeSize());
      }
      AppMethodBeat.o(125719);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LoV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        adp localadp = (adp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125719);
          return -1;
        case 1: 
          localadp.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 2: 
          localadp.LoU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125719);
          return 0;
        case 3: 
          localadp.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 4: 
          localadp.Url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localadp.LoV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 6: 
          localadp.LoW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125719);
          return 0;
        case 7: 
          localadp.LoX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cli();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cli)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localadp.LoY = ((cli)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localadp.dME = ((bcj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localadp.LoZ = ((bcl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localadp.Lpa = ((jo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localadp.Lpb = ((bcf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localadp.Lpc = ((axf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new col();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((col)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localadp.Lpd = ((col)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 15: 
          localadp.izD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125719);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localadp.Lpe = ((bcl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new css();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((css)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localadp.jfy = ((css)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      AppMethodBeat.o(125719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adp
 * JD-Core Version:    0.7.0.1
 */