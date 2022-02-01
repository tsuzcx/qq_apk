package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cdo
  extends dyy
{
  public LinkedList<bp> CQN;
  public LinkedList<chk> CQr;
  public int Tlq;
  public LinkedList<dst> Tlr;
  public int Tls;
  public int Tlt;
  public int Tlu;
  public chi Tlv;
  
  public cdo()
  {
    AppMethodBeat.i(152598);
    this.Tlr = new LinkedList();
    this.CQN = new LinkedList();
    this.CQr = new LinkedList();
    AppMethodBeat.o(152598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152599);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152599);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Tlq);
      paramVarArgs.e(3, 8, this.Tlr);
      paramVarArgs.aY(4, this.Tls);
      paramVarArgs.aY(5, this.Tlt);
      paramVarArgs.e(6, 8, this.CQN);
      paramVarArgs.aY(7, this.Tlu);
      paramVarArgs.e(8, 8, this.CQr);
      if (this.Tlv != null)
      {
        paramVarArgs.oE(9, this.Tlv.computeSize());
        this.Tlv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label992;
      }
    }
    label992:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Tlq) + g.a.a.a.c(3, 8, this.Tlr) + g.a.a.b.b.a.bM(4, this.Tls) + g.a.a.b.b.a.bM(5, this.Tlt) + g.a.a.a.c(6, 8, this.CQN) + g.a.a.b.b.a.bM(7, this.Tlu) + g.a.a.a.c(8, 8, this.CQr);
      paramInt = i;
      if (this.Tlv != null) {
        paramInt = i + g.a.a.a.oD(9, this.Tlv.computeSize());
      }
      AppMethodBeat.o(152599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tlr.clear();
        this.CQN.clear();
        this.CQr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152599);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cdo localcdo = (cdo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152599);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcdo.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 2: 
          localcdo.Tlq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152599);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dst();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dst)localObject2).parseFrom((byte[])localObject1);
            }
            localcdo.Tlr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 4: 
          localcdo.Tls = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152599);
          return 0;
        case 5: 
          localcdo.Tlt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152599);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bp)localObject2).parseFrom((byte[])localObject1);
            }
            localcdo.CQN.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 7: 
          localcdo.Tlu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152599);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new chk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((chk)localObject2).parseFrom((byte[])localObject1);
            }
            localcdo.CQr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new chi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((chi)localObject2).parseFrom((byte[])localObject1);
          }
          localcdo.Tlv = ((chi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      AppMethodBeat.o(152599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdo
 * JD-Core Version:    0.7.0.1
 */