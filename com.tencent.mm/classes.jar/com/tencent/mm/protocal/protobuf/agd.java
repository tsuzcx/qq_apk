package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agd
  extends com.tencent.mm.bx.a
{
  public String Dio;
  public LinkedList<String> Dip;
  public String appId;
  public String dbj;
  public String desc;
  public String dpv;
  public ago dve;
  public String title;
  public int type;
  
  public agd()
  {
    AppMethodBeat.i(127463);
    this.Dip = new LinkedList();
    AppMethodBeat.o(127463);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127464);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.dpv != null) {
        paramVarArgs.d(3, this.dpv);
      }
      if (this.Dio != null) {
        paramVarArgs.d(4, this.Dio);
      }
      if (this.appId != null) {
        paramVarArgs.d(5, this.appId);
      }
      if (this.dbj != null) {
        paramVarArgs.d(6, this.dbj);
      }
      paramVarArgs.e(7, 1, this.Dip);
      paramVarArgs.aR(8, this.type);
      if (this.dve != null)
      {
        paramVarArgs.kX(9, this.dve.computeSize());
        this.dve.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label778;
      }
    }
    label778:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.dpv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dpv);
      }
      paramInt = i;
      if (this.Dio != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dio);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.appId);
      }
      paramInt = i;
      if (this.dbj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dbj);
      }
      i = paramInt + f.a.a.a.c(7, 1, this.Dip) + f.a.a.b.b.a.bA(8, this.type);
      paramInt = i;
      if (this.dve != null) {
        paramInt = i + f.a.a.a.kW(9, this.dve.computeSize());
      }
      AppMethodBeat.o(127464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dip.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agd localagd = (agd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127464);
          return -1;
        case 1: 
          localagd.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 2: 
          localagd.desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 3: 
          localagd.dpv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 4: 
          localagd.Dio = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 5: 
          localagd.appId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 6: 
          localagd.dbj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 7: 
          localagd.Dip.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(127464);
          return 0;
        case 8: 
          localagd.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127464);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ago();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ago)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagd.dve = ((ago)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      AppMethodBeat.o(127464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agd
 * JD-Core Version:    0.7.0.1
 */