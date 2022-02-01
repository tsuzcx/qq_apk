package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddr
  extends dpc
{
  public String KDq;
  public String KDr;
  public String LFY;
  public String MIE;
  public String MIF;
  public String MIG;
  public String MIH;
  public String content;
  public String pTK;
  public boolean pUu;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114055);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KDq != null) {
        paramVarArgs.e(2, this.KDq);
      }
      if (this.KDr != null) {
        paramVarArgs.e(3, this.KDr);
      }
      paramVarArgs.aM(4, this.status);
      if (this.content != null) {
        paramVarArgs.e(5, this.content);
      }
      if (this.pTK != null) {
        paramVarArgs.e(6, this.pTK);
      }
      if (this.LFY != null) {
        paramVarArgs.e(7, this.LFY);
      }
      paramVarArgs.cc(8, this.pUu);
      if (this.MIE != null) {
        paramVarArgs.e(9, this.MIE);
      }
      if (this.MIF != null) {
        paramVarArgs.e(10, this.MIF);
      }
      if (this.MIG != null) {
        paramVarArgs.e(11, this.MIG);
      }
      if (this.MIH != null) {
        paramVarArgs.e(12, this.MIH);
      }
      AppMethodBeat.o(114055);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label950;
      }
    }
    label950:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KDq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KDq);
      }
      i = paramInt;
      if (this.KDr != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KDr);
      }
      i += g.a.a.b.b.a.bu(4, this.status);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.content);
      }
      i = paramInt;
      if (this.pTK != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.pTK);
      }
      paramInt = i;
      if (this.LFY != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LFY);
      }
      i = paramInt + (g.a.a.b.b.a.fS(8) + 1);
      paramInt = i;
      if (this.MIE != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MIE);
      }
      i = paramInt;
      if (this.MIF != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MIF);
      }
      paramInt = i;
      if (this.MIG != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MIG);
      }
      i = paramInt;
      if (this.MIH != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MIH);
      }
      AppMethodBeat.o(114055);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114055);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ddr localddr = (ddr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114055);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localddr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114055);
          return 0;
        case 2: 
          localddr.KDq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 3: 
          localddr.KDr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 4: 
          localddr.status = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114055);
          return 0;
        case 5: 
          localddr.content = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 6: 
          localddr.pTK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 7: 
          localddr.LFY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 8: 
          localddr.pUu = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(114055);
          return 0;
        case 9: 
          localddr.MIE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 10: 
          localddr.MIF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 11: 
          localddr.MIG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114055);
          return 0;
        }
        localddr.MIH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(114055);
        return 0;
      }
      AppMethodBeat.o(114055);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddr
 * JD-Core Version:    0.7.0.1
 */