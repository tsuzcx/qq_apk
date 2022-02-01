package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class faf
  extends dop
{
  public String Ntl;
  public String Nwa;
  public int Nwb;
  public int Nwc;
  public String Nwd;
  public int Nwe;
  public String Nwf;
  public String Nwg;
  public String dNI;
  public String dOL;
  public String pDH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82489);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dOL != null) {
        paramVarArgs.e(2, this.dOL);
      }
      if (this.Nwa != null) {
        paramVarArgs.e(3, this.Nwa);
      }
      paramVarArgs.aM(4, this.Nwb);
      paramVarArgs.aM(5, this.Nwc);
      if (this.Ntl != null) {
        paramVarArgs.e(6, this.Ntl);
      }
      if (this.pDH != null) {
        paramVarArgs.e(7, this.pDH);
      }
      if (this.dNI != null) {
        paramVarArgs.e(8, this.dNI);
      }
      if (this.Nwd != null) {
        paramVarArgs.e(9, this.Nwd);
      }
      paramVarArgs.aM(10, this.Nwe);
      if (this.Nwf != null) {
        paramVarArgs.e(11, this.Nwf);
      }
      if (this.Nwg != null) {
        paramVarArgs.e(12, this.Nwg);
      }
      AppMethodBeat.o(82489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label934;
      }
    }
    label934:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dOL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dOL);
      }
      i = paramInt;
      if (this.Nwa != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nwa);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Nwb) + g.a.a.b.b.a.bu(5, this.Nwc);
      paramInt = i;
      if (this.Ntl != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Ntl);
      }
      i = paramInt;
      if (this.pDH != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.pDH);
      }
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.dNI);
      }
      i = paramInt;
      if (this.Nwd != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Nwd);
      }
      i += g.a.a.b.b.a.bu(10, this.Nwe);
      paramInt = i;
      if (this.Nwf != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Nwf);
      }
      i = paramInt;
      if (this.Nwg != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Nwg);
      }
      AppMethodBeat.o(82489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        faf localfaf = (faf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82489);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfaf.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82489);
          return 0;
        case 2: 
          localfaf.dOL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 3: 
          localfaf.Nwa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 4: 
          localfaf.Nwb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82489);
          return 0;
        case 5: 
          localfaf.Nwc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82489);
          return 0;
        case 6: 
          localfaf.Ntl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 7: 
          localfaf.pDH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 8: 
          localfaf.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 9: 
          localfaf.Nwd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 10: 
          localfaf.Nwe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82489);
          return 0;
        case 11: 
          localfaf.Nwf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82489);
          return 0;
        }
        localfaf.Nwg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(82489);
        return 0;
      }
      AppMethodBeat.o(82489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.faf
 * JD-Core Version:    0.7.0.1
 */