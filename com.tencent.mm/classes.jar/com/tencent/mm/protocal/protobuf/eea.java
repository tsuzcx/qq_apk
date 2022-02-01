package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eea
  extends com.tencent.mm.bw.a
{
  public LinkedList<dqi> BlackList;
  public int BlackListCount;
  public int CommentCount;
  public int CreateTime;
  public int DeleteFlag;
  public LinkedList<dqi> GroupUser;
  public int GroupUserCount;
  public long Id;
  public int Nej;
  public int Nel;
  public SKBuiltinBuffer_t Nem;
  public LinkedList<edf> Nen;
  public int Neo;
  public LinkedList<edf> Nep;
  public int Neq;
  public int Ner;
  public int Nes;
  public LinkedList<edf> Net;
  public String UserName;
  public String oUJ;
  
  public eea()
  {
    AppMethodBeat.i(118461);
    this.Nen = new LinkedList();
    this.Nep = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.Net = new LinkedList();
    AppMethodBeat.o(118461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118462);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nem == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118462);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.Id);
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(3, this.oUJ);
      }
      paramVarArgs.aM(4, this.CreateTime);
      paramVarArgs.aM(5, this.Nel);
      if (this.Nem != null)
      {
        paramVarArgs.ni(6, this.Nem.computeSize());
        this.Nem.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.CommentCount);
      paramVarArgs.e(8, 8, this.Nen);
      paramVarArgs.aM(9, this.Neo);
      paramVarArgs.e(10, 8, this.Nep);
      paramVarArgs.aM(11, this.DeleteFlag);
      paramVarArgs.aM(12, this.Neq);
      paramVarArgs.aM(13, this.Nej);
      paramVarArgs.aM(14, this.Ner);
      paramVarArgs.aM(15, this.BlackListCount);
      paramVarArgs.e(16, 8, this.BlackList);
      paramVarArgs.aM(17, this.GroupUserCount);
      paramVarArgs.e(18, 8, this.GroupUser);
      paramVarArgs.aM(19, this.Nes);
      paramVarArgs.e(20, 8, this.Net);
      AppMethodBeat.o(118462);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Id) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oUJ);
      }
      i = i + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(5, this.Nel);
      paramInt = i;
      if (this.Nem != null) {
        paramInt = i + g.a.a.a.nh(6, this.Nem.computeSize());
      }
      i = g.a.a.b.b.a.bu(7, this.CommentCount);
      int j = g.a.a.a.c(8, 8, this.Nen);
      int k = g.a.a.b.b.a.bu(9, this.Neo);
      int m = g.a.a.a.c(10, 8, this.Nep);
      int n = g.a.a.b.b.a.bu(11, this.DeleteFlag);
      int i1 = g.a.a.b.b.a.bu(12, this.Neq);
      int i2 = g.a.a.b.b.a.bu(13, this.Nej);
      int i3 = g.a.a.b.b.a.bu(14, this.Ner);
      int i4 = g.a.a.b.b.a.bu(15, this.BlackListCount);
      int i5 = g.a.a.a.c(16, 8, this.BlackList);
      int i6 = g.a.a.b.b.a.bu(17, this.GroupUserCount);
      int i7 = g.a.a.a.c(18, 8, this.GroupUser);
      int i8 = g.a.a.b.b.a.bu(19, this.Nes);
      int i9 = g.a.a.a.c(20, 8, this.Net);
      AppMethodBeat.o(118462);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Nen.clear();
      this.Nep.clear();
      this.BlackList.clear();
      this.GroupUser.clear();
      this.Net.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Nem == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118462);
        throw paramVarArgs;
      }
      AppMethodBeat.o(118462);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eea localeea = (eea)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118462);
        return -1;
      case 1: 
        localeea.Id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(118462);
        return 0;
      case 2: 
        localeea.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 3: 
        localeea.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(118462);
        return 0;
      case 4: 
        localeea.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118462);
        return 0;
      case 5: 
        localeea.Nel = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118462);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeea.Nem = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 7: 
        localeea.CommentCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118462);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new edf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((edf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeea.Nen.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 9: 
        localeea.Neo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118462);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new edf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((edf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeea.Nep.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 11: 
        localeea.DeleteFlag = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118462);
        return 0;
      case 12: 
        localeea.Neq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118462);
        return 0;
      case 13: 
        localeea.Nej = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118462);
        return 0;
      case 14: 
        localeea.Ner = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118462);
        return 0;
      case 15: 
        localeea.BlackListCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118462);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeea.BlackList.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 17: 
        localeea.GroupUserCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118462);
        return 0;
      case 18: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeea.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118462);
        return 0;
      case 19: 
        localeea.Nes = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118462);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new edf();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((edf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localeea.Net.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(118462);
      return 0;
    }
    AppMethodBeat.o(118462);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eea
 * JD-Core Version:    0.7.0.1
 */