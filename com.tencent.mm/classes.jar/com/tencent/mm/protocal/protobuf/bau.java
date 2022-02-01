package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bau
  extends com.tencent.mm.cd.a
{
  public String RFk;
  public int SJK;
  public ayr SKc;
  public aza SME;
  public aza SMF;
  public bcf SMG;
  public LinkedList<bat> SMH;
  public bav SMI;
  public int status;
  
  public bau()
  {
    AppMethodBeat.i(199806);
    this.SMH = new LinkedList();
    AppMethodBeat.o(199806);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199827);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RFk != null) {
        paramVarArgs.f(1, this.RFk);
      }
      paramVarArgs.aY(2, this.SJK);
      if (this.SME != null)
      {
        paramVarArgs.oE(3, this.SME.computeSize());
        this.SME.writeFields(paramVarArgs);
      }
      if (this.SMF != null)
      {
        paramVarArgs.oE(4, this.SMF.computeSize());
        this.SMF.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.status);
      if (this.SMG != null)
      {
        paramVarArgs.oE(6, this.SMG.computeSize());
        this.SMG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.SMH);
      if (this.SMI != null)
      {
        paramVarArgs.oE(8, this.SMI.computeSize());
        this.SMI.writeFields(paramVarArgs);
      }
      if (this.SKc != null)
      {
        paramVarArgs.oE(9, this.SKc.computeSize());
        this.SKc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(199827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RFk == null) {
        break label1090;
      }
    }
    label1090:
    for (paramInt = g.a.a.b.b.a.g(1, this.RFk) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SJK);
      paramInt = i;
      if (this.SME != null) {
        paramInt = i + g.a.a.a.oD(3, this.SME.computeSize());
      }
      i = paramInt;
      if (this.SMF != null) {
        i = paramInt + g.a.a.a.oD(4, this.SMF.computeSize());
      }
      i += g.a.a.b.b.a.bM(5, this.status);
      paramInt = i;
      if (this.SMG != null) {
        paramInt = i + g.a.a.a.oD(6, this.SMG.computeSize());
      }
      i = paramInt + g.a.a.a.c(7, 8, this.SMH);
      paramInt = i;
      if (this.SMI != null) {
        paramInt = i + g.a.a.a.oD(8, this.SMI.computeSize());
      }
      i = paramInt;
      if (this.SKc != null) {
        i = paramInt + g.a.a.a.oD(9, this.SKc.computeSize());
      }
      AppMethodBeat.o(199827);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SMH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bau localbau = (bau)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199827);
          return -1;
        case 1: 
          localbau.RFk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(199827);
          return 0;
        case 2: 
          localbau.SJK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(199827);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aza)localObject2).parseFrom((byte[])localObject1);
            }
            localbau.SME = ((aza)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199827);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aza)localObject2).parseFrom((byte[])localObject1);
            }
            localbau.SMF = ((aza)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199827);
          return 0;
        case 5: 
          localbau.status = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(199827);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcf)localObject2).parseFrom((byte[])localObject1);
            }
            localbau.SMG = ((bcf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199827);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bat();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bat)localObject2).parseFrom((byte[])localObject1);
            }
            localbau.SMH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199827);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bav();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bav)localObject2).parseFrom((byte[])localObject1);
            }
            localbau.SMI = ((bav)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199827);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ayr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ayr)localObject2).parseFrom((byte[])localObject1);
          }
          localbau.SKc = ((ayr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199827);
        return 0;
      }
      AppMethodBeat.o(199827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bau
 * JD-Core Version:    0.7.0.1
 */