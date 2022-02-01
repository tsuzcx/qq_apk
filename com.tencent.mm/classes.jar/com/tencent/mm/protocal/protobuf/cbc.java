package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cbc
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public String IGV;
  public String IHo;
  public int YVh;
  public String Zpa;
  public cbl aakn;
  public String aako;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42632);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.IGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.Zpa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.IHo == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.aakn == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.oOI != null) {
        paramVarArgs.g(1, this.oOI);
      }
      if (this.IGU != null) {
        paramVarArgs.g(2, this.IGU);
      }
      if (this.Zpa != null) {
        paramVarArgs.g(3, this.Zpa);
      }
      if (this.IHo != null) {
        paramVarArgs.g(4, this.IHo);
      }
      if (this.IGV != null) {
        paramVarArgs.g(5, this.IGV);
      }
      if (this.aakn != null)
      {
        paramVarArgs.qD(6, this.aakn.computeSize());
        this.aakn.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.YVh);
      if (this.aako != null) {
        paramVarArgs.g(8, this.aako);
      }
      AppMethodBeat.o(42632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oOI == null) {
        break label936;
      }
    }
    label936:
    for (int i = i.a.a.b.b.a.h(1, this.oOI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGU);
      }
      i = paramInt;
      if (this.Zpa != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zpa);
      }
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IHo);
      }
      i = paramInt;
      if (this.IGV != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IGV);
      }
      paramInt = i;
      if (this.aakn != null) {
        paramInt = i + i.a.a.a.qC(6, this.aakn.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.YVh);
      paramInt = i;
      if (this.aako != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aako);
      }
      AppMethodBeat.o(42632);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.oOI == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.IGU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.Zpa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.IHo == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.aakn == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cbc localcbc = (cbc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42632);
          return -1;
        case 1: 
          localcbc.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 2: 
          localcbc.IGU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 3: 
          localcbc.Zpa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 4: 
          localcbc.IHo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 5: 
          localcbc.IGV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cbl localcbl = new cbl();
            if ((localObject != null) && (localObject.length > 0)) {
              localcbl.parseFrom((byte[])localObject);
            }
            localcbc.aakn = localcbl;
            paramInt += 1;
          }
          AppMethodBeat.o(42632);
          return 0;
        case 7: 
          localcbc.YVh = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(42632);
          return 0;
        }
        localcbc.aako = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(42632);
        return 0;
      }
      AppMethodBeat.o(42632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbc
 * JD-Core Version:    0.7.0.1
 */