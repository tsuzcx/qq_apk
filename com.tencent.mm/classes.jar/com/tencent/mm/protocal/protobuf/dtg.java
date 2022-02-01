package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtg
  extends com.tencent.mm.bx.a
{
  public long YSo;
  public String ZTw;
  public String aaRO;
  public LinkedList<String> aaRQ;
  public LinkedList<dlt> aaRR;
  public String aaYN;
  public long aame;
  public long aamf;
  
  public dtg()
  {
    AppMethodBeat.i(110907);
    this.aaRQ = new LinkedList();
    this.aaRR = new LinkedList();
    AppMethodBeat.o(110907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110908);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aamf);
      paramVarArgs.bv(2, this.aame);
      if (this.aaRO != null) {
        paramVarArgs.g(3, this.aaRO);
      }
      paramVarArgs.bv(4, this.YSo);
      if (this.ZTw != null) {
        paramVarArgs.g(5, this.ZTw);
      }
      paramVarArgs.e(6, 1, this.aaRQ);
      paramVarArgs.e(7, 8, this.aaRR);
      if (this.aaYN != null) {
        paramVarArgs.g(8, this.aaYN);
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.aamf) + 0 + i.a.a.b.b.a.q(2, this.aame);
      paramInt = i;
      if (this.aaRO != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aaRO);
      }
      i = paramInt + i.a.a.b.b.a.q(4, this.YSo);
      paramInt = i;
      if (this.ZTw != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZTw);
      }
      i = paramInt + i.a.a.a.c(6, 1, this.aaRQ) + i.a.a.a.c(7, 8, this.aaRR);
      paramInt = i;
      if (this.aaYN != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaYN);
      }
      AppMethodBeat.o(110908);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaRQ.clear();
      this.aaRR.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dtg localdtg = (dtg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110908);
        return -1;
      case 1: 
        localdtg.aamf = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110908);
        return 0;
      case 2: 
        localdtg.aame = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110908);
        return 0;
      case 3: 
        localdtg.aaRO = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 4: 
        localdtg.YSo = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110908);
        return 0;
      case 5: 
        localdtg.ZTw = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 6: 
        localdtg.aaRQ.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(110908);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dlt localdlt = new dlt();
          if ((localObject != null) && (localObject.length > 0)) {
            localdlt.parseFrom((byte[])localObject);
          }
          localdtg.aaRR.add(localdlt);
          paramInt += 1;
        }
        AppMethodBeat.o(110908);
        return 0;
      }
      localdtg.aaYN = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(110908);
      return 0;
    }
    AppMethodBeat.o(110908);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtg
 * JD-Core Version:    0.7.0.1
 */