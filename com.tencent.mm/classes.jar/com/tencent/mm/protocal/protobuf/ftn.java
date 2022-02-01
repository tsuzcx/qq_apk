package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ftn
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
  public int oOu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148657);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148657);
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
      AppMethodBeat.o(148657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label866;
      }
    }
    label866:
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
      AppMethodBeat.o(148657);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ftn localftn = (ftn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148657);
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
            localftn.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148657);
          return 0;
        case 2: 
          localftn.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(148657);
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
            localftn.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148657);
          return 0;
        case 4: 
          localftn.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148657);
          return 0;
        case 5: 
          localftn.abRF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(148657);
          return 0;
        case 6: 
          localftn.oOu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148657);
          return 0;
        case 7: 
          localftn.abRG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148657);
          return 0;
        case 8: 
          localftn.YIH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148657);
          return 0;
        case 9: 
          localftn.abRH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148657);
          return 0;
        }
        localftn.YIE = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(148657);
        return 0;
      }
      AppMethodBeat.o(148657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftn
 * JD-Core Version:    0.7.0.1
 */