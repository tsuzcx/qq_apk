package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctf
  extends com.tencent.mm.bw.a
{
  public String ELg;
  public String Eof;
  public String Eog;
  public String Eti;
  public String Etj;
  public int FEO;
  public caf FFd;
  public String hOf;
  public int iJT;
  public String ncR;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152685);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      if (this.Eti != null) {
        paramVarArgs.d(3, this.Eti);
      }
      if (this.Etj != null) {
        paramVarArgs.d(4, this.Etj);
      }
      paramVarArgs.aR(5, this.iJT);
      if (this.Eof != null) {
        paramVarArgs.d(6, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(7, this.Eog);
      }
      if (this.hOf != null) {
        paramVarArgs.d(8, this.hOf);
      }
      paramVarArgs.aR(9, this.FEO);
      if (this.FFd != null)
      {
        paramVarArgs.ln(10, this.FFd.computeSize());
        this.FFd.writeFields(paramVarArgs);
      }
      if (this.ELg != null) {
        paramVarArgs.d(11, this.ELg);
      }
      AppMethodBeat.o(152685);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label890;
      }
    }
    label890:
    for (int i = f.a.a.b.b.a.e(1, this.ncR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ndW);
      }
      i = paramInt;
      if (this.Eti != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Eti);
      }
      paramInt = i;
      if (this.Etj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Etj);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.iJT);
      paramInt = i;
      if (this.Eof != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Eof);
      }
      i = paramInt;
      if (this.Eog != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Eog);
      }
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hOf);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.FEO);
      paramInt = i;
      if (this.FFd != null) {
        paramInt = i + f.a.a.a.lm(10, this.FFd.computeSize());
      }
      i = paramInt;
      if (this.ELg != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ELg);
      }
      AppMethodBeat.o(152685);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152685);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctf localctf = (ctf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152685);
          return -1;
        case 1: 
          localctf.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 2: 
          localctf.ndW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 3: 
          localctf.Eti = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 4: 
          localctf.Etj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 5: 
          localctf.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152685);
          return 0;
        case 6: 
          localctf.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 7: 
          localctf.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 8: 
          localctf.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 9: 
          localctf.FEO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152685);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((caf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctf.FFd = ((caf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152685);
          return 0;
        }
        localctf.ELg = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152685);
        return 0;
      }
      AppMethodBeat.o(152685);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctf
 * JD-Core Version:    0.7.0.1
 */