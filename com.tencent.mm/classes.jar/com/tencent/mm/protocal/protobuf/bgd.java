package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bgd
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public int KWb;
  public bgm LPR;
  public String LPS;
  public String LoI;
  public String Name;
  public String jfi;
  public String xIK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42632);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.LoI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.IconUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.LPR == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.jfi != null) {
        paramVarArgs.e(1, this.jfi);
      }
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      if (this.LoI != null) {
        paramVarArgs.e(3, this.LoI);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(4, this.IconUrl);
      }
      if (this.xIK != null) {
        paramVarArgs.e(5, this.xIK);
      }
      if (this.LPR != null)
      {
        paramVarArgs.ni(6, this.LPR.computeSize());
        this.LPR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.KWb);
      if (this.LPS != null) {
        paramVarArgs.e(8, this.LPS);
      }
      AppMethodBeat.o(42632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jfi == null) {
        break label962;
      }
    }
    label962:
    for (int i = g.a.a.b.b.a.f(1, this.jfi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Name);
      }
      i = paramInt;
      if (this.LoI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LoI);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.IconUrl);
      }
      i = paramInt;
      if (this.xIK != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xIK);
      }
      paramInt = i;
      if (this.LPR != null) {
        paramInt = i + g.a.a.a.nh(6, this.LPR.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.KWb);
      paramInt = i;
      if (this.LPS != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LPS);
      }
      AppMethodBeat.o(42632);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.jfi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.Name == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.LoI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.IconUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.LPR == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42632);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgd localbgd = (bgd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42632);
          return -1;
        case 1: 
          localbgd.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 2: 
          localbgd.Name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 3: 
          localbgd.LoI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 4: 
          localbgd.IconUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 5: 
          localbgd.xIK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bgm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbgd.LPR = ((bgm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42632);
          return 0;
        case 7: 
          localbgd.KWb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(42632);
          return 0;
        }
        localbgd.LPS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(42632);
        return 0;
      }
      AppMethodBeat.o(42632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgd
 * JD-Core Version:    0.7.0.1
 */