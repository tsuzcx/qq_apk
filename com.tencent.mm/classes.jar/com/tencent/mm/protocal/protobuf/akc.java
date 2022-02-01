package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akc
  extends com.tencent.mm.bw.a
{
  public String GBP;
  public LinkedList<String> GBQ;
  public String appId;
  public akn dFV;
  public String desc;
  public String dkZ;
  public String dzZ;
  public String title;
  public int type;
  
  public akc()
  {
    AppMethodBeat.i(127463);
    this.GBQ = new LinkedList();
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
      if (this.dzZ != null) {
        paramVarArgs.d(3, this.dzZ);
      }
      if (this.GBP != null) {
        paramVarArgs.d(4, this.GBP);
      }
      if (this.appId != null) {
        paramVarArgs.d(5, this.appId);
      }
      if (this.dkZ != null) {
        paramVarArgs.d(6, this.dkZ);
      }
      paramVarArgs.e(7, 1, this.GBQ);
      paramVarArgs.aS(8, this.type);
      if (this.dFV != null)
      {
        paramVarArgs.lJ(9, this.dFV.computeSize());
        this.dFV.writeFields(paramVarArgs);
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
      if (this.dzZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dzZ);
      }
      paramInt = i;
      if (this.GBP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GBP);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.appId);
      }
      paramInt = i;
      if (this.dkZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dkZ);
      }
      i = paramInt + f.a.a.a.c(7, 1, this.GBQ) + f.a.a.b.b.a.bz(8, this.type);
      paramInt = i;
      if (this.dFV != null) {
        paramInt = i + f.a.a.a.lI(9, this.dFV.computeSize());
      }
      AppMethodBeat.o(127464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GBQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akc localakc = (akc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127464);
          return -1;
        case 1: 
          localakc.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 2: 
          localakc.desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 3: 
          localakc.dzZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 4: 
          localakc.GBP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 5: 
          localakc.appId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 6: 
          localakc.dkZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 7: 
          localakc.GBQ.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(127464);
          return 0;
        case 8: 
          localakc.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127464);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new akn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((akn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakc.dFV = ((akn)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akc
 * JD-Core Version:    0.7.0.1
 */