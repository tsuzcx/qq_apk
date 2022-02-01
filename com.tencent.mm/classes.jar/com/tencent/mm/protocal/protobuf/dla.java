package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dla
  extends com.tencent.mm.bw.a
{
  public LinkedList<dky> DMp;
  public String FTK;
  public String FTL;
  public bps FTM;
  public int FTN;
  public dkz FTO;
  public dkz FTP;
  public int Fyw;
  public String desc;
  public String title;
  
  public dla()
  {
    AppMethodBeat.i(72617);
    this.DMp = new LinkedList();
    AppMethodBeat.o(72617);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.FTK != null) {
        paramVarArgs.d(3, this.FTK);
      }
      if (this.FTL != null) {
        paramVarArgs.d(4, this.FTL);
      }
      if (this.FTM != null)
      {
        paramVarArgs.ln(5, this.FTM.computeSize());
        this.FTM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.DMp);
      paramVarArgs.aR(7, this.Fyw);
      paramVarArgs.aR(8, this.FTN);
      if (this.FTO != null)
      {
        paramVarArgs.ln(9, this.FTO.computeSize());
        this.FTO.writeFields(paramVarArgs);
      }
      if (this.FTP != null)
      {
        paramVarArgs.ln(10, this.FTP.computeSize());
        this.FTP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.FTK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FTK);
      }
      paramInt = i;
      if (this.FTL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FTL);
      }
      i = paramInt;
      if (this.FTM != null) {
        i = paramInt + f.a.a.a.lm(5, this.FTM.computeSize());
      }
      i = i + f.a.a.a.c(6, 8, this.DMp) + f.a.a.b.b.a.bx(7, this.Fyw) + f.a.a.b.b.a.bx(8, this.FTN);
      paramInt = i;
      if (this.FTO != null) {
        paramInt = i + f.a.a.a.lm(9, this.FTO.computeSize());
      }
      i = paramInt;
      if (this.FTP != null) {
        i = paramInt + f.a.a.a.lm(10, this.FTP.computeSize());
      }
      AppMethodBeat.o(72618);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DMp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dla localdla = (dla)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72618);
          return -1;
        case 1: 
          localdla.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 2: 
          localdla.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 3: 
          localdla.FTK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 4: 
          localdla.FTL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bps();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bps)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdla.FTM = ((bps)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dky();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dky)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdla.DMp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 7: 
          localdla.Fyw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72618);
          return 0;
        case 8: 
          localdla.FTN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72618);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdla.FTO = ((dkz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdla.FTP = ((dkz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      AppMethodBeat.o(72618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dla
 * JD-Core Version:    0.7.0.1
 */