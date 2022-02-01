package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class TimeLineObject
  extends com.tencent.mm.bw.a
{
  public String AiG;
  public String AkC;
  public int CreateTime;
  public String Fnm;
  public String HUD;
  public bwk HUE;
  public en HUF;
  public abo HUG;
  public String HUH;
  public int HUI;
  public int HUJ;
  public String HUK;
  public dlc HUL;
  public edv HUM;
  public int HUN;
  public int Hml;
  public String Id;
  public int eQZ;
  public int hCH;
  public String kbH;
  public String nIJ;
  public ba zFf;
  public egh zFh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      paramVarArgs.aS(3, this.Hml);
      paramVarArgs.aS(4, this.CreateTime);
      if (this.HUD != null) {
        paramVarArgs.d(5, this.HUD);
      }
      if (this.HUE != null)
      {
        paramVarArgs.lJ(6, this.HUE.computeSize());
        this.HUE.writeFields(paramVarArgs);
      }
      if (this.HUF != null)
      {
        paramVarArgs.lJ(7, this.HUF.computeSize());
        this.HUF.writeFields(paramVarArgs);
      }
      if (this.HUG != null)
      {
        paramVarArgs.lJ(8, this.HUG.computeSize());
        this.HUG.writeFields(paramVarArgs);
      }
      if (this.kbH != null) {
        paramVarArgs.d(9, this.kbH);
      }
      if (this.Fnm != null) {
        paramVarArgs.d(10, this.Fnm);
      }
      if (this.HUH != null) {
        paramVarArgs.d(11, this.HUH);
      }
      paramVarArgs.aS(12, this.HUI);
      paramVarArgs.aS(13, this.HUJ);
      if (this.HUK != null) {
        paramVarArgs.d(14, this.HUK);
      }
      if (this.zFf != null)
      {
        paramVarArgs.lJ(15, this.zFf.computeSize());
        this.zFf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.hCH);
      if (this.HUL != null)
      {
        paramVarArgs.lJ(17, this.HUL.computeSize());
        this.HUL.writeFields(paramVarArgs);
      }
      if (this.AiG != null) {
        paramVarArgs.d(18, this.AiG);
      }
      if (this.AkC != null) {
        paramVarArgs.d(19, this.AkC);
      }
      if (this.HUM != null)
      {
        paramVarArgs.lJ(20, this.HUM.computeSize());
        this.HUM.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(21, this.HUN);
      if (this.zFh != null)
      {
        paramVarArgs.lJ(22, this.zFh.computeSize());
        this.zFh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(23, this.eQZ);
      AppMethodBeat.o(125847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2114;
      }
    }
    label2114:
    for (paramInt = f.a.a.b.b.a.e(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = i + f.a.a.b.b.a.bz(3, this.Hml) + f.a.a.b.b.a.bz(4, this.CreateTime);
      paramInt = i;
      if (this.HUD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HUD);
      }
      i = paramInt;
      if (this.HUE != null) {
        i = paramInt + f.a.a.a.lI(6, this.HUE.computeSize());
      }
      paramInt = i;
      if (this.HUF != null) {
        paramInt = i + f.a.a.a.lI(7, this.HUF.computeSize());
      }
      i = paramInt;
      if (this.HUG != null) {
        i = paramInt + f.a.a.a.lI(8, this.HUG.computeSize());
      }
      paramInt = i;
      if (this.kbH != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.kbH);
      }
      i = paramInt;
      if (this.Fnm != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Fnm);
      }
      paramInt = i;
      if (this.HUH != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HUH);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.HUI) + f.a.a.b.b.a.bz(13, this.HUJ);
      paramInt = i;
      if (this.HUK != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HUK);
      }
      i = paramInt;
      if (this.zFf != null) {
        i = paramInt + f.a.a.a.lI(15, this.zFf.computeSize());
      }
      i += f.a.a.b.b.a.bz(16, this.hCH);
      paramInt = i;
      if (this.HUL != null) {
        paramInt = i + f.a.a.a.lI(17, this.HUL.computeSize());
      }
      i = paramInt;
      if (this.AiG != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.AiG);
      }
      paramInt = i;
      if (this.AkC != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.AkC);
      }
      i = paramInt;
      if (this.HUM != null) {
        i = paramInt + f.a.a.a.lI(20, this.HUM.computeSize());
      }
      i += f.a.a.b.b.a.bz(21, this.HUN);
      paramInt = i;
      if (this.zFh != null) {
        paramInt = i + f.a.a.a.lI(22, this.zFh.computeSize());
      }
      i = f.a.a.b.b.a.bz(23, this.eQZ);
      AppMethodBeat.o(125847);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125847);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        TimeLineObject localTimeLineObject = (TimeLineObject)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125847);
          return -1;
        case 1: 
          localTimeLineObject.Id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 2: 
          localTimeLineObject.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 3: 
          localTimeLineObject.Hml = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 4: 
          localTimeLineObject.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 5: 
          localTimeLineObject.HUD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.HUE = ((bwk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new en();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((en)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.HUF = ((en)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.HUG = ((abo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 9: 
          localTimeLineObject.kbH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 10: 
          localTimeLineObject.Fnm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 11: 
          localTimeLineObject.HUH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 12: 
          localTimeLineObject.HUI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 13: 
          localTimeLineObject.HUJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 14: 
          localTimeLineObject.HUK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ba();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.zFf = ((ba)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 16: 
          localTimeLineObject.hCH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.HUL = ((dlc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 18: 
          localTimeLineObject.AiG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 19: 
          localTimeLineObject.AkC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125847);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new edv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((edv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.HUM = ((edv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        case 21: 
          localTimeLineObject.HUN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125847);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localTimeLineObject.zFh = ((egh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125847);
          return 0;
        }
        localTimeLineObject.eQZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125847);
        return 0;
      }
      AppMethodBeat.o(125847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.TimeLineObject
 * JD-Core Version:    0.7.0.1
 */