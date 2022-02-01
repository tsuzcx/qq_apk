package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fmn
  extends com.tencent.mm.bx.a
{
  public gjc ZtE;
  public long abMK;
  public long abML;
  public long abMM;
  public long abMN;
  public LinkedList<b> abMO;
  public long begin_time;
  public long duration;
  public String text;
  
  public fmn()
  {
    AppMethodBeat.i(110911);
    this.abMO = new LinkedList();
    AppMethodBeat.o(110911);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110912);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZtE != null)
      {
        paramVarArgs.qD(1, this.ZtE.computeSize());
        this.ZtE.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.begin_time);
      paramVarArgs.bv(3, this.duration);
      if (this.text != null) {
        paramVarArgs.g(4, this.text);
      }
      paramVarArgs.bv(5, this.abMK);
      paramVarArgs.bv(6, this.abML);
      paramVarArgs.bv(7, this.abMM);
      paramVarArgs.bv(8, this.abMN);
      paramVarArgs.e(9, 6, this.abMO);
      AppMethodBeat.o(110912);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZtE == null) {
        break label684;
      }
    }
    label684:
    for (paramInt = i.a.a.a.qC(1, this.ZtE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.begin_time) + i.a.a.b.b.a.q(3, this.duration);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.text);
      }
      i = i.a.a.b.b.a.q(5, this.abMK);
      int j = i.a.a.b.b.a.q(6, this.abML);
      int k = i.a.a.b.b.a.q(7, this.abMM);
      int m = i.a.a.b.b.a.q(8, this.abMN);
      int n = i.a.a.a.c(9, 6, this.abMO);
      AppMethodBeat.o(110912);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abMO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(110912);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fmn localfmn = (fmn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110912);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gjc localgjc = new gjc();
            if ((localObject != null) && (localObject.length > 0)) {
              localgjc.parseFrom((byte[])localObject);
            }
            localfmn.ZtE = localgjc;
            paramInt += 1;
          }
          AppMethodBeat.o(110912);
          return 0;
        case 2: 
          localfmn.begin_time = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(110912);
          return 0;
        case 3: 
          localfmn.duration = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(110912);
          return 0;
        case 4: 
          localfmn.text = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(110912);
          return 0;
        case 5: 
          localfmn.abMK = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(110912);
          return 0;
        case 6: 
          localfmn.abML = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(110912);
          return 0;
        case 7: 
          localfmn.abMM = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(110912);
          return 0;
        case 8: 
          localfmn.abMN = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(110912);
          return 0;
        }
        localfmn.abMO.add(((i.a.a.a.a)localObject).ajGk.kFX());
        AppMethodBeat.o(110912);
        return 0;
      }
      AppMethodBeat.o(110912);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmn
 * JD-Core Version:    0.7.0.1
 */