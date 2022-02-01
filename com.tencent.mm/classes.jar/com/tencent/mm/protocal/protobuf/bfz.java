package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfz
  extends com.tencent.mm.bx.a
{
  public dcm DDG;
  public dcm DDH;
  public String DDI;
  public String DDJ;
  public boolean DDK = false;
  public boolean DDL;
  public bgd DDM;
  public String DnF;
  public String DnG;
  public boolean DnH = false;
  public boolean DnI = false;
  public int flags;
  public int msgType = -1;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.msgType);
      if (this.DDG != null)
      {
        paramVarArgs.kX(2, this.DDG.computeSize());
        this.DDG.writeFields(paramVarArgs);
      }
      if (this.DDH != null)
      {
        paramVarArgs.kX(3, this.DDH.computeSize());
        this.DDH.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(4, this.DnH);
      if (this.DnF != null) {
        paramVarArgs.d(5, this.DnF);
      }
      paramVarArgs.aR(6, this.flags);
      if (this.DnG != null) {
        paramVarArgs.d(7, this.DnG);
      }
      if (this.DDI != null) {
        paramVarArgs.d(8, this.DDI);
      }
      if (this.DDJ != null) {
        paramVarArgs.d(9, this.DDJ);
      }
      paramVarArgs.bg(10, this.DDK);
      paramVarArgs.bg(11, this.DDL);
      paramVarArgs.bg(12, this.DnI);
      if (this.DDM != null)
      {
        paramVarArgs.kX(13, this.DDM.computeSize());
        this.DDM.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(14, this.timestamp);
      AppMethodBeat.o(122507);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.msgType) + 0;
      paramInt = i;
      if (this.DDG != null) {
        paramInt = i + f.a.a.a.kW(2, this.DDG.computeSize());
      }
      i = paramInt;
      if (this.DDH != null) {
        i = paramInt + f.a.a.a.kW(3, this.DDH.computeSize());
      }
      i += f.a.a.b.b.a.fY(4) + 1;
      paramInt = i;
      if (this.DnF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DnF);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.flags);
      paramInt = i;
      if (this.DnG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DnG);
      }
      i = paramInt;
      if (this.DDI != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DDI);
      }
      paramInt = i;
      if (this.DDJ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DDJ);
      }
      i = paramInt + (f.a.a.b.b.a.fY(10) + 1) + (f.a.a.b.b.a.fY(11) + 1) + (f.a.a.b.b.a.fY(12) + 1);
      paramInt = i;
      if (this.DDM != null) {
        paramInt = i + f.a.a.a.kW(13, this.DDM.computeSize());
      }
      i = f.a.a.b.b.a.q(14, this.timestamp);
      AppMethodBeat.o(122507);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bfz localbfz = (bfz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122507);
        return -1;
      case 1: 
        localbfz.msgType = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(122507);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbfz.DDG = ((dcm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbfz.DDH = ((dcm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 4: 
        localbfz.DnH = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(122507);
        return 0;
      case 5: 
        localbfz.DnF = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 6: 
        localbfz.flags = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(122507);
        return 0;
      case 7: 
        localbfz.DnG = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 8: 
        localbfz.DDI = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 9: 
        localbfz.DDJ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 10: 
        localbfz.DDK = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(122507);
        return 0;
      case 11: 
        localbfz.DDL = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(122507);
        return 0;
      case 12: 
        localbfz.DnI = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(122507);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbfz.DDM = ((bgd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      }
      localbfz.timestamp = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(122507);
      return 0;
    }
    AppMethodBeat.o(122507);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfz
 * JD-Core Version:    0.7.0.1
 */