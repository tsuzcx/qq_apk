package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxd
  extends com.tencent.mm.bx.a
{
  public dcm DDG;
  public dcm DDH;
  public String DDI;
  public String DDJ;
  public String DnF;
  public String DnG;
  public boolean DnH = false;
  public int flags;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DDG != null)
      {
        paramVarArgs.kX(1, this.DDG.computeSize());
        this.DDG.writeFields(paramVarArgs);
      }
      if (this.DDH != null)
      {
        paramVarArgs.kX(2, this.DDH.computeSize());
        this.DDH.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(3, this.DnH);
      if (this.DnF != null) {
        paramVarArgs.d(4, this.DnF);
      }
      paramVarArgs.aR(5, this.flags);
      if (this.DnG != null) {
        paramVarArgs.d(6, this.DnG);
      }
      if (this.DDI != null) {
        paramVarArgs.d(7, this.DDI);
      }
      if (this.DDJ != null) {
        paramVarArgs.d(8, this.DDJ);
      }
      paramVarArgs.aG(9, this.timestamp);
      AppMethodBeat.o(122550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DDG == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.kW(1, this.DDG.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DDH != null) {
        i = paramInt + f.a.a.a.kW(2, this.DDH.computeSize());
      }
      i += f.a.a.b.b.a.fY(3) + 1;
      paramInt = i;
      if (this.DnF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DnF);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.flags);
      paramInt = i;
      if (this.DnG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DnG);
      }
      i = paramInt;
      if (this.DDI != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DDI);
      }
      paramInt = i;
      if (this.DDJ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DDJ);
      }
      i = f.a.a.b.b.a.q(9, this.timestamp);
      AppMethodBeat.o(122550);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxd localcxd = (cxd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122550);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxd.DDG = ((dcm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
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
            localcxd.DDH = ((dcm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 3: 
          localcxd.DnH = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(122550);
          return 0;
        case 4: 
          localcxd.DnF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 5: 
          localcxd.flags = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122550);
          return 0;
        case 6: 
          localcxd.DnG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 7: 
          localcxd.DDI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 8: 
          localcxd.DDJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122550);
          return 0;
        }
        localcxd.timestamp = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(122550);
        return 0;
      }
      AppMethodBeat.o(122550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxd
 * JD-Core Version:    0.7.0.1
 */