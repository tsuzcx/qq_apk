package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehk
  extends com.tencent.mm.bx.a
{
  public int Zms;
  public boolean aavl;
  public LinkedList<duv> abmF;
  public String abmG;
  public String jump_url;
  public String wording;
  
  public ehk()
  {
    AppMethodBeat.i(176148);
    this.abmF = new LinkedList();
    AppMethodBeat.o(176148);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176149);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.abmF);
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.abmG != null) {
        paramVarArgs.g(3, this.abmG);
      }
      if (this.jump_url != null) {
        paramVarArgs.g(4, this.jump_url);
      }
      paramVarArgs.di(5, this.aavl);
      paramVarArgs.bS(6, this.Zms);
      AppMethodBeat.o(176149);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.abmF) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.abmG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abmG);
      }
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.jump_url);
      }
      i = i.a.a.b.b.a.ko(5);
      int j = i.a.a.b.b.a.cJ(6, this.Zms);
      AppMethodBeat.o(176149);
      return paramInt + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abmF.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(176149);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ehk localehk = (ehk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176149);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          duv localduv = new duv();
          if ((localObject != null) && (localObject.length > 0)) {
            localduv.parseFrom((byte[])localObject);
          }
          localehk.abmF.add(localduv);
          paramInt += 1;
        }
        AppMethodBeat.o(176149);
        return 0;
      case 2: 
        localehk.wording = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 3: 
        localehk.abmG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 4: 
        localehk.jump_url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 5: 
        localehk.aavl = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(176149);
        return 0;
      }
      localehk.Zms = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(176149);
      return 0;
    }
    AppMethodBeat.o(176149);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehk
 * JD-Core Version:    0.7.0.1
 */