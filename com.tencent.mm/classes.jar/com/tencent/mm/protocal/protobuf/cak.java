package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cak
  extends com.tencent.mm.bx.a
{
  public bui Auc;
  public long feedId;
  public String objectNonceId;
  public int scene;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258543);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.feedId);
      if (this.objectNonceId != null) {
        paramVarArgs.g(2, this.objectNonceId);
      }
      paramVarArgs.bS(3, this.scene);
      if (this.Auc != null)
      {
        paramVarArgs.qD(4, this.Auc.computeSize());
        this.Auc.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.g(5, this.sessionBuffer);
      }
      AppMethodBeat.o(258543);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.feedId) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.objectNonceId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.scene);
      paramInt = i;
      if (this.Auc != null) {
        paramInt = i + i.a.a.a.qC(4, this.Auc.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.sessionBuffer);
      }
      AppMethodBeat.o(258543);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258543);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cak localcak = (cak)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258543);
        return -1;
      case 1: 
        localcak.feedId = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258543);
        return 0;
      case 2: 
        localcak.objectNonceId = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258543);
        return 0;
      case 3: 
        localcak.scene = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258543);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bui localbui = new bui();
          if ((localObject != null) && (localObject.length > 0)) {
            localbui.parseFrom((byte[])localObject);
          }
          localcak.Auc = localbui;
          paramInt += 1;
        }
        AppMethodBeat.o(258543);
        return 0;
      }
      localcak.sessionBuffer = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258543);
      return 0;
    }
    AppMethodBeat.o(258543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cak
 * JD-Core Version:    0.7.0.1
 */