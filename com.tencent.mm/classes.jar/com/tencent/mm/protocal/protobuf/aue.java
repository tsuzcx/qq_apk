package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aue
  extends com.tencent.mm.bx.a
{
  public int FJz;
  public String GaD;
  public aun Gsp;
  public String Gsq;
  public String IconUrl;
  public String Name;
  public String iht;
  public String ufh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iht == null)
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
      if (this.GaD == null)
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
      if (this.Gsp == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.iht != null) {
        paramVarArgs.d(1, this.iht);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.GaD != null) {
        paramVarArgs.d(3, this.GaD);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(4, this.IconUrl);
      }
      if (this.ufh != null) {
        paramVarArgs.d(5, this.ufh);
      }
      if (this.Gsp != null)
      {
        paramVarArgs.lC(6, this.Gsp.computeSize());
        this.Gsp.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.FJz);
      if (this.Gsq != null) {
        paramVarArgs.d(8, this.Gsq);
      }
      AppMethodBeat.o(42632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iht == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.b.b.a.e(1, this.iht) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.GaD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GaD);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IconUrl);
      }
      i = paramInt;
      if (this.ufh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ufh);
      }
      paramInt = i;
      if (this.Gsp != null) {
        paramInt = i + f.a.a.a.lB(6, this.Gsp.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.FJz);
      paramInt = i;
      if (this.Gsq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gsq);
      }
      AppMethodBeat.o(42632);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.iht == null)
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
        if (this.GaD == null)
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
        if (this.Gsp == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aue localaue = (aue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42632);
          return -1;
        case 1: 
          localaue.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 2: 
          localaue.Name = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 3: 
          localaue.GaD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 4: 
          localaue.IconUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 5: 
          localaue.ufh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aun();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aun)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaue.Gsp = ((aun)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42632);
          return 0;
        case 7: 
          localaue.FJz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(42632);
          return 0;
        }
        localaue.Gsq = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(42632);
        return 0;
      }
      AppMethodBeat.o(42632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aue
 * JD-Core Version:    0.7.0.1
 */