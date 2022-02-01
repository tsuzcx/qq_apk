package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bl
  extends com.tencent.mm.bw.a
{
  public String DOj;
  public String DOk;
  public String DOl;
  public String DOm;
  public String DOn;
  public String DOo;
  public eco DOp;
  public String DOq;
  public String fZx;
  public String tii;
  public String tkL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fZx != null) {
        paramVarArgs.d(1, this.fZx);
      }
      if (this.DOj != null) {
        paramVarArgs.d(2, this.DOj);
      }
      if (this.DOk != null) {
        paramVarArgs.d(3, this.DOk);
      }
      if (this.tii != null) {
        paramVarArgs.d(4, this.tii);
      }
      if (this.tkL != null) {
        paramVarArgs.d(5, this.tkL);
      }
      if (this.DOl != null) {
        paramVarArgs.d(6, this.DOl);
      }
      if (this.DOm != null) {
        paramVarArgs.d(7, this.DOm);
      }
      if (this.DOn != null) {
        paramVarArgs.d(8, this.DOn);
      }
      if (this.DOo != null) {
        paramVarArgs.d(9, this.DOo);
      }
      if (this.DOp != null)
      {
        paramVarArgs.ln(10, this.DOp.computeSize());
        this.DOp.writeFields(paramVarArgs);
      }
      if (this.DOq != null) {
        paramVarArgs.d(11, this.DOq);
      }
      AppMethodBeat.o(152478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fZx == null) {
        break label922;
      }
    }
    label922:
    for (int i = f.a.a.b.b.a.e(1, this.fZx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DOj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DOj);
      }
      i = paramInt;
      if (this.DOk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DOk);
      }
      paramInt = i;
      if (this.tii != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tii);
      }
      i = paramInt;
      if (this.tkL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tkL);
      }
      paramInt = i;
      if (this.DOl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DOl);
      }
      i = paramInt;
      if (this.DOm != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DOm);
      }
      paramInt = i;
      if (this.DOn != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DOn);
      }
      i = paramInt;
      if (this.DOo != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DOo);
      }
      paramInt = i;
      if (this.DOp != null) {
        paramInt = i + f.a.a.a.lm(10, this.DOp.computeSize());
      }
      i = paramInt;
      if (this.DOq != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DOq);
      }
      AppMethodBeat.o(152478);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bl localbl = (bl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152478);
          return -1;
        case 1: 
          localbl.fZx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 2: 
          localbl.DOj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 3: 
          localbl.DOk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 4: 
          localbl.tii = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 5: 
          localbl.tkL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 6: 
          localbl.DOl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 7: 
          localbl.DOm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 8: 
          localbl.DOn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 9: 
          localbl.DOo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eco();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbl.DOp = ((eco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152478);
          return 0;
        }
        localbl.DOq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152478);
        return 0;
      }
      AppMethodBeat.o(152478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bl
 * JD-Core Version:    0.7.0.1
 */