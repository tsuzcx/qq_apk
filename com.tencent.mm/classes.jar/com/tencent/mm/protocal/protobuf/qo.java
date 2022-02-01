package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qo
  extends com.tencent.mm.bx.a
{
  public String IJA;
  public String UserName;
  public int YFu;
  public String YPo;
  public LinkedList<String> YVA;
  public int YVB;
  public String YVH;
  public LinkedList<qn> YVI;
  public String pSi;
  public String vhX;
  
  public qo()
  {
    AppMethodBeat.i(257891);
    this.YVI = new LinkedList();
    this.YVA = new LinkedList();
    AppMethodBeat.o(257891);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257896);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YFu);
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(3, this.vhX);
      }
      if (this.IJA != null) {
        paramVarArgs.g(4, this.IJA);
      }
      if (this.pSi != null) {
        paramVarArgs.g(5, this.pSi);
      }
      if (this.YPo != null) {
        paramVarArgs.g(6, this.YPo);
      }
      if (this.YVH != null) {
        paramVarArgs.g(7, this.YVH);
      }
      paramVarArgs.e(8, 8, this.YVI);
      paramVarArgs.e(9, 1, this.YVA);
      paramVarArgs.bS(10, this.YVB);
      AppMethodBeat.o(257896);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YFu) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.vhX);
      }
      paramInt = i;
      if (this.IJA != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IJA);
      }
      i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.pSi);
      }
      paramInt = i;
      if (this.YPo != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YPo);
      }
      i = paramInt;
      if (this.YVH != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YVH);
      }
      paramInt = i.a.a.a.c(8, 8, this.YVI);
      int j = i.a.a.a.c(9, 1, this.YVA);
      int k = i.a.a.b.b.a.cJ(10, this.YVB);
      AppMethodBeat.o(257896);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YVI.clear();
      this.YVA.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257896);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      qo localqo = (qo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257896);
        return -1;
      case 1: 
        localqo.YFu = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257896);
        return 0;
      case 2: 
        localqo.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257896);
        return 0;
      case 3: 
        localqo.vhX = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257896);
        return 0;
      case 4: 
        localqo.IJA = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257896);
        return 0;
      case 5: 
        localqo.pSi = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257896);
        return 0;
      case 6: 
        localqo.YPo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257896);
        return 0;
      case 7: 
        localqo.YVH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257896);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          qn localqn = new qn();
          if ((localObject != null) && (localObject.length > 0)) {
            localqn.parseFrom((byte[])localObject);
          }
          localqo.YVI.add(localqn);
          paramInt += 1;
        }
        AppMethodBeat.o(257896);
        return 0;
      case 9: 
        localqo.YVA.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(257896);
        return 0;
      }
      localqo.YVB = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(257896);
      return 0;
    }
    AppMethodBeat.o(257896);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qo
 * JD-Core Version:    0.7.0.1
 */