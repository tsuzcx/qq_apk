package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epd
  extends com.tencent.mm.cd.a
{
  public String RTS;
  public LinkedList<cpf> Sar;
  public String TBB;
  public int UrA;
  public String UrB;
  public String UrC;
  public int UrD;
  public int UrE;
  public int UrF;
  public String UrG;
  public int Uru;
  public int Urv;
  public int Urw;
  public int Urx;
  public int Ury;
  public int Urz;
  public String fwr;
  
  public epd()
  {
    AppMethodBeat.i(152702);
    this.Sar = new LinkedList();
    AppMethodBeat.o(152702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152703);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TBB != null) {
        paramVarArgs.f(1, this.TBB);
      }
      paramVarArgs.aY(2, this.Uru);
      paramVarArgs.aY(3, this.Urv);
      paramVarArgs.aY(4, this.Urw);
      paramVarArgs.aY(5, this.Urx);
      if (this.fwr != null) {
        paramVarArgs.f(6, this.fwr);
      }
      paramVarArgs.e(7, 8, this.Sar);
      paramVarArgs.aY(8, this.Ury);
      if (this.RTS != null) {
        paramVarArgs.f(9, this.RTS);
      }
      paramVarArgs.aY(10, this.Urz);
      paramVarArgs.aY(11, this.UrA);
      if (this.UrB != null) {
        paramVarArgs.f(12, this.UrB);
      }
      if (this.UrC != null) {
        paramVarArgs.f(13, this.UrC);
      }
      paramVarArgs.aY(14, this.UrD);
      paramVarArgs.aY(16, this.UrE);
      paramVarArgs.aY(17, this.UrF);
      if (this.UrG != null) {
        paramVarArgs.f(18, this.UrG);
      }
      AppMethodBeat.o(152703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TBB == null) {
        break label1088;
      }
    }
    label1088:
    for (paramInt = g.a.a.b.b.a.g(1, this.TBB) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Uru) + g.a.a.b.b.a.bM(3, this.Urv) + g.a.a.b.b.a.bM(4, this.Urw) + g.a.a.b.b.a.bM(5, this.Urx);
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fwr);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.Sar) + g.a.a.b.b.a.bM(8, this.Ury);
      paramInt = i;
      if (this.RTS != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.RTS);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.Urz) + g.a.a.b.b.a.bM(11, this.UrA);
      paramInt = i;
      if (this.UrB != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.UrB);
      }
      i = paramInt;
      if (this.UrC != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.UrC);
      }
      i = i + g.a.a.b.b.a.bM(14, this.UrD) + g.a.a.b.b.a.bM(16, this.UrE) + g.a.a.b.b.a.bM(17, this.UrF);
      paramInt = i;
      if (this.UrG != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.UrG);
      }
      AppMethodBeat.o(152703);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sar.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        epd localepd = (epd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        default: 
          AppMethodBeat.o(152703);
          return -1;
        case 1: 
          localepd.TBB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 2: 
          localepd.Uru = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152703);
          return 0;
        case 3: 
          localepd.Urv = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152703);
          return 0;
        case 4: 
          localepd.Urw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152703);
          return 0;
        case 5: 
          localepd.Urx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152703);
          return 0;
        case 6: 
          localepd.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cpf localcpf = new cpf();
            if ((localObject != null) && (localObject.length > 0)) {
              localcpf.parseFrom((byte[])localObject);
            }
            localepd.Sar.add(localcpf);
            paramInt += 1;
          }
          AppMethodBeat.o(152703);
          return 0;
        case 8: 
          localepd.Ury = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152703);
          return 0;
        case 9: 
          localepd.RTS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 10: 
          localepd.Urz = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152703);
          return 0;
        case 11: 
          localepd.UrA = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152703);
          return 0;
        case 12: 
          localepd.UrB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 13: 
          localepd.UrC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 14: 
          localepd.UrD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152703);
          return 0;
        case 16: 
          localepd.UrE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152703);
          return 0;
        case 17: 
          localepd.UrF = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152703);
          return 0;
        }
        localepd.UrG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152703);
        return 0;
      }
      AppMethodBeat.o(152703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epd
 * JD-Core Version:    0.7.0.1
 */