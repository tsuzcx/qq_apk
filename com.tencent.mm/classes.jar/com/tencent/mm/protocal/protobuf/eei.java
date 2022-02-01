package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class eei
  extends com.tencent.mm.bx.a
{
  public LinkedList<eeg> HPw;
  public boolean HPx;
  public boolean HPy;
  public boolean HPz;
  public String dwX;
  public long iud;
  public String oki;
  public String omw;
  public String url;
  
  public eei()
  {
    AppMethodBeat.i(209612);
    this.HPw = new LinkedList();
    AppMethodBeat.o(209612);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209613);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(209613);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      paramVarArgs.aY(2, this.iud);
      paramVarArgs.bt(3, this.HPx);
      paramVarArgs.bt(4, this.HPy);
      if (this.oki != null) {
        paramVarArgs.d(5, this.oki);
      }
      if (this.omw != null) {
        paramVarArgs.d(6, this.omw);
      }
      if (this.dwX != null) {
        paramVarArgs.d(7, this.dwX);
      }
      paramVarArgs.bt(8, this.HPz);
      paramVarArgs.e(9, 8, this.HPw);
      AppMethodBeat.o(209613);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.iud) + f.a.a.b.b.a.alV(3) + f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.oki != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.oki);
      }
      i = paramInt;
      if (this.omw != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.omw);
      }
      paramInt = i;
      if (this.dwX != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dwX);
      }
      i = f.a.a.b.b.a.alV(8);
      int j = f.a.a.a.c(9, 8, this.HPw);
      AppMethodBeat.o(209613);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HPw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(209613);
          throw paramVarArgs;
        }
        AppMethodBeat.o(209613);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eei localeei = (eei)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209613);
          return -1;
        case 1: 
          localeei.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209613);
          return 0;
        case 2: 
          localeei.iud = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(209613);
          return 0;
        case 3: 
          localeei.HPx = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(209613);
          return 0;
        case 4: 
          localeei.HPy = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(209613);
          return 0;
        case 5: 
          localeei.oki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209613);
          return 0;
        case 6: 
          localeei.omw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209613);
          return 0;
        case 7: 
          localeei.dwX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209613);
          return 0;
        case 8: 
          localeei.HPz = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(209613);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eeg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eeg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeei.HPw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209613);
        return 0;
      }
      AppMethodBeat.o(209613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eei
 * JD-Core Version:    0.7.0.1
 */