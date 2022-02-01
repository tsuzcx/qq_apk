package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class auu
  extends com.tencent.mm.bw.a
{
  public avd GLN;
  public String GLO;
  public int GbY;
  public String Gtk;
  public String IconUrl;
  public String Name;
  public String ikm;
  public String uqr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm == null)
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
      if (this.Gtk == null)
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
      if (this.GLN == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.ikm != null) {
        paramVarArgs.d(1, this.ikm);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.Gtk != null) {
        paramVarArgs.d(3, this.Gtk);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(4, this.IconUrl);
      }
      if (this.uqr != null) {
        paramVarArgs.d(5, this.uqr);
      }
      if (this.GLN != null)
      {
        paramVarArgs.lJ(6, this.GLN.computeSize());
        this.GLN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.GbY);
      if (this.GLO != null) {
        paramVarArgs.d(8, this.GLO);
      }
      AppMethodBeat.o(42632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ikm == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.b.b.a.e(1, this.ikm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.Gtk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gtk);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IconUrl);
      }
      i = paramInt;
      if (this.uqr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uqr);
      }
      paramInt = i;
      if (this.GLN != null) {
        paramInt = i + f.a.a.a.lI(6, this.GLN.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.GbY);
      paramInt = i;
      if (this.GLO != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GLO);
      }
      AppMethodBeat.o(42632);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.ikm == null)
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
        if (this.Gtk == null)
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
        if (this.GLN == null)
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
        auu localauu = (auu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42632);
          return -1;
        case 1: 
          localauu.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 2: 
          localauu.Name = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 3: 
          localauu.Gtk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 4: 
          localauu.IconUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 5: 
          localauu.uqr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((avd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauu.GLN = ((avd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42632);
          return 0;
        case 7: 
          localauu.GbY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(42632);
          return 0;
        }
        localauu.GLO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(42632);
        return 0;
      }
      AppMethodBeat.o(42632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auu
 * JD-Core Version:    0.7.0.1
 */