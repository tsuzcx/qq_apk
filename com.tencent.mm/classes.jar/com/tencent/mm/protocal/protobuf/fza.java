package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fza
  extends erp
{
  public gol NkQ;
  public String UserName;
  public int YIE;
  public int YIH;
  public int YYs;
  public String abRF;
  public int abRG;
  public int abRH;
  public LinkedList<etl> abWA;
  public LinkedList<gol> abWB;
  public int abWy;
  public int abWz;
  public int oOu;
  
  public fza()
  {
    AppMethodBeat.i(148663);
    this.abWA = new LinkedList();
    this.abWB = new LinkedList();
    AppMethodBeat.o(148663);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148664);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148664);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.NkQ != null)
      {
        paramVarArgs.qD(3, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.YYs);
      if (this.abRF != null) {
        paramVarArgs.g(5, this.abRF);
      }
      paramVarArgs.bS(6, this.oOu);
      paramVarArgs.bS(7, this.abRG);
      paramVarArgs.bS(8, this.YIH);
      paramVarArgs.bS(9, this.abRH);
      paramVarArgs.bS(10, this.YIE);
      paramVarArgs.bS(11, this.abWy);
      paramVarArgs.bS(12, this.abWz);
      paramVarArgs.e(13, 8, this.abWA);
      paramVarArgs.e(14, 8, this.abWB);
      AppMethodBeat.o(148664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1206;
      }
    }
    label1206:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.NkQ != null) {
        i = paramInt + i.a.a.a.qC(3, this.NkQ.computeSize());
      }
      i += i.a.a.b.b.a.cJ(4, this.YYs);
      paramInt = i;
      if (this.abRF != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abRF);
      }
      i = i.a.a.b.b.a.cJ(6, this.oOu);
      int j = i.a.a.b.b.a.cJ(7, this.abRG);
      int k = i.a.a.b.b.a.cJ(8, this.YIH);
      int m = i.a.a.b.b.a.cJ(9, this.abRH);
      int n = i.a.a.b.b.a.cJ(10, this.YIE);
      int i1 = i.a.a.b.b.a.cJ(11, this.abWy);
      int i2 = i.a.a.b.b.a.cJ(12, this.abWz);
      int i3 = i.a.a.a.c(13, 8, this.abWA);
      int i4 = i.a.a.a.c(14, 8, this.abWB);
      AppMethodBeat.o(148664);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abWA.clear();
        this.abWB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148664);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fza localfza = (fza)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148664);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfza.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 2: 
          localfza.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfza.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 4: 
          localfza.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148664);
          return 0;
        case 5: 
          localfza.abRF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 6: 
          localfza.oOu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148664);
          return 0;
        case 7: 
          localfza.abRG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148664);
          return 0;
        case 8: 
          localfza.YIH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148664);
          return 0;
        case 9: 
          localfza.abRH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148664);
          return 0;
        case 10: 
          localfza.YIE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148664);
          return 0;
        case 11: 
          localfza.abWy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148664);
          return 0;
        case 12: 
          localfza.abWz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148664);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfza.abWA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localfza.abWB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      AppMethodBeat.o(148664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fza
 * JD-Core Version:    0.7.0.1
 */