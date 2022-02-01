package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnz
  extends com.tencent.mm.bw.a
{
  public LinkedList<doa> FVF;
  public String FVG;
  public int FVH;
  public int Flv;
  public int apptype;
  public String djj;
  public String hiX;
  public String nYv;
  
  public dnz()
  {
    AppMethodBeat.i(74672);
    this.FVF = new LinkedList();
    AppMethodBeat.o(74672);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74673);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj != null) {
        paramVarArgs.d(1, this.djj);
      }
      if (this.hiX != null) {
        paramVarArgs.d(2, this.hiX);
      }
      paramVarArgs.aR(3, this.apptype);
      paramVarArgs.e(4, 8, this.FVF);
      paramVarArgs.aR(5, this.Flv);
      if (this.FVG != null) {
        paramVarArgs.d(6, this.FVG);
      }
      if (this.nYv != null) {
        paramVarArgs.d(7, this.nYv);
      }
      paramVarArgs.aR(8, this.FVH);
      AppMethodBeat.o(74673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djj == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.djj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hiX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hiX);
      }
      i = i + f.a.a.b.b.a.bx(3, this.apptype) + f.a.a.a.c(4, 8, this.FVF) + f.a.a.b.b.a.bx(5, this.Flv);
      paramInt = i;
      if (this.FVG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FVG);
      }
      i = paramInt;
      if (this.nYv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.nYv);
      }
      paramInt = f.a.a.b.b.a.bx(8, this.FVH);
      AppMethodBeat.o(74673);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FVF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(74673);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnz localdnz = (dnz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74673);
          return -1;
        case 1: 
          localdnz.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 2: 
          localdnz.hiX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 3: 
          localdnz.apptype = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(74673);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new doa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((doa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnz.FVF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74673);
          return 0;
        case 5: 
          localdnz.Flv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(74673);
          return 0;
        case 6: 
          localdnz.FVG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 7: 
          localdnz.nYv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(74673);
          return 0;
        }
        localdnz.FVH = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(74673);
        return 0;
      }
      AppMethodBeat.o(74673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnz
 * JD-Core Version:    0.7.0.1
 */