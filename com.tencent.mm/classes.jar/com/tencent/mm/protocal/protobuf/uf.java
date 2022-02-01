package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uf
  extends com.tencent.mm.bw.a
{
  public String KDM;
  public String LcR;
  public String LdG;
  public int Ldc;
  public String Ldd;
  public un Lde;
  public String Ldf;
  public String eaO;
  public String gTG;
  public int nHh;
  public String qGB;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201323);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.eaO != null) {
        paramVarArgs.e(1, this.eaO);
      }
      if (this.KDM != null) {
        paramVarArgs.e(2, this.KDM);
      }
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.gTG != null) {
        paramVarArgs.e(4, this.gTG);
      }
      if (this.LdG != null) {
        paramVarArgs.e(5, this.LdG);
      }
      if (this.LcR != null) {
        paramVarArgs.e(6, this.LcR);
      }
      paramVarArgs.aM(7, this.nHh);
      if (this.qGB != null) {
        paramVarArgs.e(8, this.qGB);
      }
      paramVarArgs.aM(9, this.Ldc);
      if (this.Ldd != null) {
        paramVarArgs.e(10, this.Ldd);
      }
      if (this.Lde != null)
      {
        paramVarArgs.ni(11, this.Lde.computeSize());
        this.Lde.writeFields(paramVarArgs);
      }
      if (this.Ldf != null) {
        paramVarArgs.e(12, this.Ldf);
      }
      AppMethodBeat.o(201323);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eaO == null) {
        break label954;
      }
    }
    label954:
    for (int i = g.a.a.b.b.a.f(1, this.eaO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KDM != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KDM);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.title);
      }
      paramInt = i;
      if (this.gTG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.gTG);
      }
      i = paramInt;
      if (this.LdG != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LdG);
      }
      paramInt = i;
      if (this.LcR != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LcR);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.nHh);
      paramInt = i;
      if (this.qGB != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.qGB);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.Ldc);
      paramInt = i;
      if (this.Ldd != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Ldd);
      }
      i = paramInt;
      if (this.Lde != null) {
        i = paramInt + g.a.a.a.nh(11, this.Lde.computeSize());
      }
      paramInt = i;
      if (this.Ldf != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.Ldf);
      }
      AppMethodBeat.o(201323);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(201323);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        uf localuf = (uf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201323);
          return -1;
        case 1: 
          localuf.eaO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201323);
          return 0;
        case 2: 
          localuf.KDM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201323);
          return 0;
        case 3: 
          localuf.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201323);
          return 0;
        case 4: 
          localuf.gTG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201323);
          return 0;
        case 5: 
          localuf.LdG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201323);
          return 0;
        case 6: 
          localuf.LcR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201323);
          return 0;
        case 7: 
          localuf.nHh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201323);
          return 0;
        case 8: 
          localuf.qGB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201323);
          return 0;
        case 9: 
          localuf.Ldc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201323);
          return 0;
        case 10: 
          localuf.Ldd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201323);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localuf.Lde = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201323);
          return 0;
        }
        localuf.Ldf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(201323);
        return 0;
      }
      AppMethodBeat.o(201323);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uf
 * JD-Core Version:    0.7.0.1
 */