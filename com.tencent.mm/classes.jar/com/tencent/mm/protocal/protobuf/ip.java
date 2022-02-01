package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ip
  extends dop
{
  public int KMC;
  public LinkedList<adi> KMD;
  public String KME;
  public String KMF;
  public String KMG;
  public int Scene;
  public long oTS;
  
  public ip()
  {
    AppMethodBeat.i(32133);
    this.KMD = new LinkedList();
    AppMethodBeat.o(32133);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32134);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KMC);
      paramVarArgs.e(3, 8, this.KMD);
      if (this.KME != null) {
        paramVarArgs.e(4, this.KME);
      }
      if (this.KMF != null) {
        paramVarArgs.e(5, this.KMF);
      }
      paramVarArgs.aM(6, this.Scene);
      paramVarArgs.bb(7, this.oTS);
      if (this.KMG != null) {
        paramVarArgs.e(8, this.KMG);
      }
      AppMethodBeat.o(32134);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KMC) + g.a.a.a.c(3, 8, this.KMD);
      paramInt = i;
      if (this.KME != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KME);
      }
      i = paramInt;
      if (this.KMF != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KMF);
      }
      i = i + g.a.a.b.b.a.bu(6, this.Scene) + g.a.a.b.b.a.r(7, this.oTS);
      paramInt = i;
      if (this.KMG != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KMG);
      }
      AppMethodBeat.o(32134);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KMD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32134);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ip localip = (ip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32134);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localip.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32134);
          return 0;
        case 2: 
          localip.KMC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32134);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localip.KMD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32134);
          return 0;
        case 4: 
          localip.KME = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32134);
          return 0;
        case 5: 
          localip.KMF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32134);
          return 0;
        case 6: 
          localip.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32134);
          return 0;
        case 7: 
          localip.oTS = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32134);
          return 0;
        }
        localip.KMG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32134);
        return 0;
      }
      AppMethodBeat.o(32134);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ip
 * JD-Core Version:    0.7.0.1
 */