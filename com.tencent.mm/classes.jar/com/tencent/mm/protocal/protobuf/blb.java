package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blb
  extends erp
{
  public long Azu;
  public long DUP;
  public atz ZEc;
  public int ZNM;
  public String finderUsername;
  public long hKN;
  public long liveId;
  public String object_nonce_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259384);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEc != null)
      {
        paramVarArgs.qD(2, this.ZEc.computeSize());
        this.ZEc.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.g(3, this.finderUsername);
      }
      paramVarArgs.bv(4, this.liveId);
      paramVarArgs.bv(5, this.hKN);
      paramVarArgs.bv(6, this.Azu);
      paramVarArgs.bS(7, this.scene);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(8, this.object_nonce_id);
      }
      paramVarArgs.bS(9, this.ZNM);
      paramVarArgs.bv(10, this.DUP);
      AppMethodBeat.o(259384);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label806;
      }
    }
    label806:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZEc != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.finderUsername);
      }
      i = i + i.a.a.b.b.a.q(4, this.liveId) + i.a.a.b.b.a.q(5, this.hKN) + i.a.a.b.b.a.q(6, this.Azu) + i.a.a.b.b.a.cJ(7, this.scene);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.object_nonce_id);
      }
      i = i.a.a.b.b.a.cJ(9, this.ZNM);
      int j = i.a.a.b.b.a.q(10, this.DUP);
      AppMethodBeat.o(259384);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259384);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        blb localblb = (blb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259384);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localblb.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259384);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localblb.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259384);
          return 0;
        case 3: 
          localblb.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259384);
          return 0;
        case 4: 
          localblb.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259384);
          return 0;
        case 5: 
          localblb.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259384);
          return 0;
        case 6: 
          localblb.Azu = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259384);
          return 0;
        case 7: 
          localblb.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259384);
          return 0;
        case 8: 
          localblb.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259384);
          return 0;
        case 9: 
          localblb.ZNM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259384);
          return 0;
        }
        localblb.DUP = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(259384);
        return 0;
      }
      AppMethodBeat.o(259384);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blb
 * JD-Core Version:    0.7.0.1
 */