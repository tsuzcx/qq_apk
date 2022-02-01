package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class fak
  extends com.tencent.mm.bw.a
{
  public LinkedList<fai> NwC;
  public boolean NwD;
  public boolean NwE;
  public boolean NwF;
  public String appId;
  public String dPJ;
  public int hDa;
  public long jsm;
  public String pDI;
  public String pFJ;
  public int pmN;
  public String url;
  
  public fak()
  {
    AppMethodBeat.i(224552);
    this.NwC = new LinkedList();
    AppMethodBeat.o(224552);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(224553);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(224553);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      paramVarArgs.bb(2, this.jsm);
      paramVarArgs.cc(3, this.NwD);
      paramVarArgs.cc(4, this.NwE);
      if (this.pDI != null) {
        paramVarArgs.e(5, this.pDI);
      }
      if (this.pFJ != null) {
        paramVarArgs.e(6, this.pFJ);
      }
      if (this.dPJ != null) {
        paramVarArgs.e(7, this.dPJ);
      }
      paramVarArgs.cc(8, this.NwF);
      paramVarArgs.e(9, 8, this.NwC);
      paramVarArgs.aM(10, this.hDa);
      paramVarArgs.aM(11, this.pmN);
      if (this.appId != null) {
        paramVarArgs.e(12, this.appId);
      }
      AppMethodBeat.o(224553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = g.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.jsm) + (g.a.a.b.b.a.fS(3) + 1) + (g.a.a.b.b.a.fS(4) + 1);
      paramInt = i;
      if (this.pDI != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.pDI);
      }
      i = paramInt;
      if (this.pFJ != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.pFJ);
      }
      paramInt = i;
      if (this.dPJ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.dPJ);
      }
      i = paramInt + (g.a.a.b.b.a.fS(8) + 1) + g.a.a.a.c(9, 8, this.NwC) + g.a.a.b.b.a.bu(10, this.hDa) + g.a.a.b.b.a.bu(11, this.pmN);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.appId);
      }
      AppMethodBeat.o(224553);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NwC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(224553);
          throw paramVarArgs;
        }
        AppMethodBeat.o(224553);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fak localfak = (fak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(224553);
          return -1;
        case 1: 
          localfak.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(224553);
          return 0;
        case 2: 
          localfak.jsm = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(224553);
          return 0;
        case 3: 
          localfak.NwD = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(224553);
          return 0;
        case 4: 
          localfak.NwE = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(224553);
          return 0;
        case 5: 
          localfak.pDI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(224553);
          return 0;
        case 6: 
          localfak.pFJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(224553);
          return 0;
        case 7: 
          localfak.dPJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(224553);
          return 0;
        case 8: 
          localfak.NwF = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(224553);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fai();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((fai)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfak.NwC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(224553);
          return 0;
        case 10: 
          localfak.hDa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(224553);
          return 0;
        case 11: 
          localfak.pmN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(224553);
          return 0;
        }
        localfak.appId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(224553);
        return 0;
      }
      AppMethodBeat.o(224553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fak
 * JD-Core Version:    0.7.0.1
 */